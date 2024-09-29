package cn.jinsulive.lagrange.spring.autoconfigure.processor;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.io.resource.FileResource;
import cn.hutool.core.io.resource.Resource;
import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
import java.util.HashMap;
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
        Gson gson = new Gson();
        JsonObject resourceJson = gson.fromJson(resourceString, JsonObject.class);
        if (resourceJson.isEmpty()) {
            return new OriginTrackedMapPropertySource(name, Collections.emptyMap(), true);
        }
        Map<String, Object> map = flattenJson(resourceJson, "");
        return new OriginTrackedMapPropertySource(name, Collections.unmodifiableMap(map), true);
    }

    public static Map<String, Object> flattenJson(JsonElement element, String prefix) {
        Map<String, Object> flatMap = new HashMap<>();
        if (element.isJsonObject()) {
            JsonObject jsonObject = element.getAsJsonObject();
            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                String key = prefix.isEmpty() ? entry.getKey() : prefix + "." + entry.getKey();
                flatMap.putAll(flattenJson(entry.getValue(), key));
            }
        } else if (element.isJsonArray()) {
            JsonArray jsonArray = element.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                String key = prefix + "[" + i + "]";
                flatMap.putAll(flattenJson(jsonArray.get(i), key));
            }
        } else {
            flatMap.put(prefix, element.getAsString());
        }
        return flatMap;
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