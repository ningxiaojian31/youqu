package cn.zdxh.commons.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * 页面或者服务之间传输的TUser对象
 */
@Data
public class TUserDTO {
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 登录名（邮箱号）
     */
    @NotEmpty(message="邮箱不允许为空")
    @Email(message = "邮箱号不合法")
    private String username;
    /**
     * 密码（加密）
     */
    @NotEmpty(message="密码不允许为空")
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 类型。1管理员2普通用户
     */
    private Integer type;
    /**
     * 用户头像
     */
    private String image;
    /**
     * 性别。1男2女
     */
    private Integer sex;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 个性签名
     */
    private String signature;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * token
     */
    private String token;

}
