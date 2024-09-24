package cn.jinsulive.lagrange.sdk.response.other.data;

import cn.hutool.json.JSONUtil;

/**
 * @author lxy
 * @since 2024年09月11日 15:59:08
 */
public class GetRecordData {

    /**
     * 转换后的语音文件路径
     */
    private String file;

    public GetRecordData() {
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

}
