package cn.jinsulive.lagrange.sdk.request.expand;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.EmptyResponse;

/**
 * 私聊发送文件
 *
 * @author lxy
 * @since 2024年09月12日 17:35:33
 */
public class UploadPrivateFileRequest extends AbstractRequest<EmptyResponse> {

    /**
     * 对方QQ号
     */
    private Long userId;
    /**
     * 本地文件路径
     */
    private String file;
    /**
     * 储存名称
     */
    private String name;

    public UploadPrivateFileRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getServiceUrl() {
        return "upload_private_file";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("user_id", userId)
                .putOpt("file", file)
                .putOpt("name", name);
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }
}
