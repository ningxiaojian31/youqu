package cn.zdxh.invitation.enums;

/**
 * 帖子审核状态
 */
public enum InvCheckStatusEnum {

    NO_CHECK_INV(0,"未审核"),
    PASS_INV(1,"审核通过"),
    NO_PASS_INV(2,"审核未通过"),
    ;
    private Integer code;
    private String name;

    InvCheckStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static InvCheckStatusEnum getStatusName(Integer code){
        if (code != null){
           for (InvCheckStatusEnum statusEnum:InvCheckStatusEnum.values()){
               if (statusEnum.getCode() == code ){
                   return statusEnum;
               }
           }
        }
        return null;
    }
}
