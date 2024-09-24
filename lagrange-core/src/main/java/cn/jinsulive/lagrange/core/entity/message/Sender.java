package cn.jinsulive.lagrange.core.entity.message;

import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.core.constant.RoleType;
import cn.jinsulive.lagrange.core.constant.SexType;

/**
 * @author lxy
 * @since 2024年03月06日 14:28:36
 */
public class Sender {

    private long userId;
    private String nickname;
    private String card;
    private SexType sex;
    private int age;
    private String area;
    private String level;
    private RoleType role;
    private String title;

    public Sender() {
    }

    private Sender(Builder builder) {
        userId = builder.userId;
        nickname = builder.nickname;
        card = builder.card;
        sex = builder.sex;
        age = builder.age;
        area = builder.area;
        level = builder.level;
        role = builder.role;
        title = builder.title;
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static final class Builder {
        private long userId;
        private String nickname;
        private String card;
        private SexType sex;
        private int age;
        private String area;
        private String level;
        private RoleType role;
        private String title;

        private Builder() {
        }

        public Builder userId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder card(String card) {
            this.card = card;
            return this;
        }

        public Builder sex(SexType sex) {
            this.sex = sex;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder area(String area) {
            this.area = area;
            return this;
        }

        public Builder level(String level) {
            this.level = level;
            return this;
        }

        public Builder role(RoleType role) {
            this.role = role;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Sender build() {
            return new Sender(this);
        }
    }

}
