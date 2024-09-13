package com.jinsulive.lagrange.spring.autoconfigure.processor;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.io.resource.FileResource;
import cn.hutool.core.io.resource.Resource;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.util.JsonUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.boot.logging.DeferredLog;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;

import javax.annotation.Nullable;
import java.io.*;
import java.util.Collections;
import java.util.Map;

/**
 * @author lxy
 * @since 2024年03月19日 17:25:41
 */
public class JsonEnvironmentPostProcessor implements EnvironmentPostProcessor, ApplicationListener<ApplicationEvent> {

    private static final DeferredLog log = new DeferredLog();

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
                log.debug(String.format("try to load %s from 'classpath' error. e: %s", jsonSourceName, e.getMessage()));
            }
            try {
                resource = new FileResource(System.getProperty("user.dir") + File.separator + jsonSourceName);
                propertySource = loadJsonPropertySource(jsonSourceName, resource);
                break;
            } catch (Exception e) {
                log.debug(String.format("try to load %s from 'user.dir' error. e: %s", jsonSourceName, e.getMessage()));
            }
        }
        if (propertySource == null) {
            log.warn("fail to load 'lagrange.json' or 'config/lagrange.json', check whether the storage path is correct. " +
                    "if you has been configured in YAML mode, ignore it.");
        }
        if (propertySource != null) {
            environment.getPropertySources().addLast(propertySource);
        }
    }

    public PropertySource<?> loadJsonPropertySource(String name, Resource resource) throws IOException {
        String resourceString = readResourceAsString(resource);
        if (StrUtil.isBlank(resourceString)) {
            return null;
        }
        JSONObject resourceJson = JsonUtil.toJsonObj(resourceString);
        if (resourceJson == null) {
            return null;
        }
        if (resourceJson.isEmpty()) {
            return new OriginTrackedMapPropertySource(name, Collections.emptyMap(), true);
        }
        return new OriginTrackedMapPropertySource(name, Collections.unmodifiableMap(resourceJson), true);
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

    @Override
    public void onApplicationEvent(@Nullable ApplicationEvent event) {
        log.replayTo(JsonEnvironmentPostProcessor.class);
    }
}