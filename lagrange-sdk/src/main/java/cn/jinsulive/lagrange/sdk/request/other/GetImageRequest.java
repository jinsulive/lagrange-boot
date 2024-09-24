package cn.jinsulive.lagrange.sdk.request.other;

import cn.hutool.http.Method;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.sdk.LagrangeNotRealizedYet;
import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.other.GetImageResponse;

/**
 * 获取图片
 *
 * @author lxy
 * @since 2024年09月11日 16:00:28
 */
@LagrangeNotRealizedYet
public class GetImageRequest extends AbstractRequest<GetImageResponse> {
    /**
     * 收到的图片文件名（消息段的 file 参数）
     */
    private String file;

    public GetImageRequest() {
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public String getServiceUrl() {
        return "get_image";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("file", file);
    }

    @Override
    public Class<GetImageResponse> getResponseClass() {
        return GetImageResponse.class;
    }
}
