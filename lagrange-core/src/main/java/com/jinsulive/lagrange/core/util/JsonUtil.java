package com.jinsulive.lagrange.core.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lxy
 * @since 2024年03月06日 13:38:56
 */
public class JsonUtil {

    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);

    public static JSONObject toJsonObj(String content) {
        if (StrUtil.isBlank(content) || !JSONUtil.isTypeJSONObject(content)) {
            return JSONUtil.createObj();
        }
        try {
            return JSONUtil.parseObj(content);
        } catch (Exception e) {
            log.error("content转换json object异常 content: {}", content, e);
            return JSONUtil.createObj();
        }
    }

}
