package com.jinsulive.lagrange.spring.autoconfigure.processor;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.io.resource.FileResource;
import cn.hutool.core.io.resource.Resource;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lxy
 * @since 2024年03月19日 17:25:41
 */
public class JsonEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(JsonEnvironmentPostProcessor.class);

    private final String[] jsonSourceNames = new String[]{"lagrange.json", "config/lagrange.json"};

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        PropertySource<?> propertySource = null;
        Resource resource;
        for (String jsonSourceName : jsonSourceNames) {
            try {
                resource = new ClassPathResource(jsonSourceName);
                propertySource = loadJsonPropertySource(jsonSourceName, resource);
                break;
            } catch (Exception e) {
                log.warn("尝试加载ClassPath配置文件异常: {}, e: {}", jsonSourceName, e.getMessage());
            }
            try {
                resource = new FileResource(System.getProperty("user.dir") + File.separator + jsonSourceName);
                propertySource = loadJsonPropertySource(jsonSourceName, resource);
                break;
            } catch (Exception e) {
                log.warn("尝试从外部加载配置文件异常: {}, e: {}", jsonSourceName, e.getMessage());
            }
        }
        if (propertySource == null) {
            throw new RuntimeException("lagrange.json 配置文件加载异常, 请查看配置文件存放路径是否正确");
        }
        environment.getPropertySources().addLast(propertySource);
    }

    public PropertySource<?> loadJsonPropertySource(String name, Resource resource) throws IOException {
        String resourceString = readResourceAsString(resource);
        JSONObject resourceJson = JsonUtil.toJsonObj(resourceString);
        Map<String, Object> map = new HashMap<>();
        resourceJson.forEach((key, value) -> putEntry(map, key, value));
        if (map.isEmpty()) {
            return new OriginTrackedMapPropertySource(name, Collections.emptyMap(), true);
        }
        return new OriginTrackedMapPropertySource(name, Collections.unmodifiableMap(map), true);
    }


    /***
     * 针对多级的结构
     */
    private void putEntry(Map<String, Object> map, String key, Object value) {
        if (value instanceof JSONObject) {
            ((JSONObject) value).forEach((key1, value1) -> putEntry(map, key + "." + key1, value1));
        } else if (value instanceof JSONArray) {
            map.put(key, convertArray((JSONArray) value));
        } else {
            map.put(key, value);
        }
    }

    /**
     * 将json数组转换为字符串 格式如下: 1,2,3
     */
    private String convertArray(JSONArray array) {
        if (array.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        array.forEach(value -> {
            builder.append(",");
            if (value instanceof JSONObject || value instanceof JSONArray) {
                builder.append(JSONUtil.parse(value));
            } else {
                builder.append(value);
            }
        });
        return builder.substring(1);
    }

    /**
     * 将资源加载为一个字符串
     */
    private String readResourceAsString(Resource resource) throws IOException {
        StringBuilder builder = new StringBuilder();
        InputStream in = resource.getStream();
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            builder.append(str);
        }
        //关闭流
        bufferedReader.close();
        inputStreamReader.close();
        in.close();
        return builder.toString();
    }
}