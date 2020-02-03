package cn.zdxh.user.enums;

/**
 * @author ningxj
 * @date 2020-2-3 20:57
 */
public enum FansFocusEnum {

    FOCUS_ENUM(1,"关注"),
    FANS_ENUM(2,"粉丝")
    ;

    private Integer type;
    private String msg;

   FansFocusEnum(Integer type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public Integer getType() {
        return type;
    }

    public String getMsg() {
        return msg;
    }
}
