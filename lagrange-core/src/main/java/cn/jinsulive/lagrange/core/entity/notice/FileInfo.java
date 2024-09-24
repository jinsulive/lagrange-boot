package cn.jinsulive.lagrange.core.entity.notice;

/**
 * @author lxy
 * @since 2024年09月08日 11:24:17
 */
public class FileInfo {

    /**
     * 文件 ID
     */
    private String id;

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件大小（字节数）
     */
    private Long size;

    /**
     * busid（目前不清楚有什么作用）
     */
    private Long busid;

    public FileInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getBusid() {
        return busid;
    }

    public void setBusid(Long busid) {
        this.busid = busid;
    }
}
