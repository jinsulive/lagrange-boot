package com.jinsulive.lagrange.spring.autoconfigure.processor;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.io.resource.Resource;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lxy
 * @since 2024年03月19日 17:25:41
 */
@Slf4j
public class JsonEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private final String[] jsonSourceNames = new String[]{"lagrange.json"};

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        for (String jsonSourceName : jsonSourceNames) {
            loadJsonFile(jsonSourceName, environment);
        }
    }

    public void loadJsonFile(String jsonFile, ConfigurableEnvironment environment) {
        Resource resource = new ClassPathResource(jsonFile);
        try {
            PropertySource<?> propertySource = loadJsonPropertySource(jsonFile, resource);
            environment.getPropertySources().addLast(propertySource);
        } catch (IOException e) {
            log.error("load json file: {} error. {}", jsonFile, e.getMessage(), e);
        }
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