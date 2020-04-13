package cn.zdxh.commons.utils;

/**
 * 记录日志类型
 */
public enum SystemLogEnum {

    SAVE_LOG("保存"),
    DELETE_LOG("删除"),
    REGISTER_LOG("注册"),
    LOGIN_LOG("登录"),
    LAUD_LOG("点赞"),
    COLLECT_LOG("收藏"),
    THROW_LOG("异常"),
    ;
    private String type;

    SystemLogEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
