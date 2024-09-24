package cn.jinsulive.lagrange.core.constant;

/**
 * 特殊字符
 *
 * @author lxy
 * @since 2024年06月09日 01:28:43
 */
public enum SpecialCharacter {

    LINE_FEED("\n"),
    ;

    private String value;

    SpecialCharacter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
