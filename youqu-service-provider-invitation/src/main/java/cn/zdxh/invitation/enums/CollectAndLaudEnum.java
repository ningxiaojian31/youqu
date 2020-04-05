package cn.zdxh.invitation.enums;

/**
 * 收藏和点赞的key前缀
 */
public enum CollectAndLaudEnum {

    COLLEC_INV("collect-inv-","文章收藏"),
    LAUD_INV("laud-inv-","文章点赞"),
    LAUD_COM("laud-com-","评论点赞")
    ;

    private String name;
    private String msg;

    CollectAndLaudEnum(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public String getMsg() {
        return msg;
    }
}
