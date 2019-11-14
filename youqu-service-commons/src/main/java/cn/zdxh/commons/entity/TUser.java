package cn.zdxh.commons.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
public class TUser extends Model<TUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 登录名（手机号）
     */
    @NotEmpty(message="手机号码不允许为空")
    @Pattern(regexp="^1[3456789]\\d{9}$",message="手机号码格式不正确")
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TUser{" +
        ", id=" + id +
        ", username=" + username +
        ", password=" + password +
        ", nickname=" + nickname +
        ", type=" + type +
        ", image=" + image +
        ", sex=" + sex +
        ", birthday=" + birthday +
        ", signature=" + signature +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
