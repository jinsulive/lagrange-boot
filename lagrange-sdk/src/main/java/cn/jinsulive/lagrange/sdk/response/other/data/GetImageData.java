package cn.jinsulive.lagrange.sdk.response.other.data;

import cn.hutool.json.JSONUtil;

/**
 * @author lxy
 * @since 2024年09月11日 16:02:29
 */
public class GetImageData {

    /**
     * 下载后的图片文件路径
     */
    private String file;

    public GetImageData() {
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
