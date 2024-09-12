package com.jinsulive.lagrange.sdk.request.other;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.other.GetRecordResponse;

/**
 * 获取语音
 *
 * @author lxy
 * @since 2024年09月11日 15:55:51
 */
public class GetRecordRequest extends AbstractRequest<GetRecordResponse> {

    /**
     * 收到的语音文件名（消息段的 file 参数）
     */
    private String file;
    /**
     * 要转换到的格式，目前支持 mp3、amr、wma、m4a、spx、ogg、wav、flac
     */
    private String outFormat;

    @Override
    public String getServiceUrl() {
        return "get_record";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("file", file)
                .putOpt("out_format", outFormat);
    }

    @Override
    public Class<GetRecordResponse> getResponseClass() {
        return GetRecordResponse.class;
    }

}
