package cn.zdxh.commons.dto;

import lombok.Data;

@Data
public class TUserPersonDTO {
    private static final long serialVersionUID = 1L;
    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 登录名（邮箱号）
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 用户头像
     */
    private String image;
    /**
     * 关注总数
     */
    private String focusCount;
    /**
     * 粉丝总数
     */
    private String fansCount;

}
