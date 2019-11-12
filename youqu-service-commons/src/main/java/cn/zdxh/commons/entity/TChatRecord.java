package cn.zdxh.commons.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 聊天记录表
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
public class TChatRecord extends Model<TChatRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 好友id
     */
    private Integer friendId;
    /**
     * 可读。1未读2已读
     */
    private Integer hasRead;
    /**
     * 具体讯息
     */
    private String message;
    /**
     * 创建时间
     */
    private Date reateTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public Integer getHasRead() {
        return hasRead;
    }

    public void setHasRead(Integer hasRead) {
        this.hasRead = hasRead;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getReateTime() {
        return reateTime;
    }

    public void setReateTime(Date reateTime) {
        this.reateTime = reateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TChatRecord{" +
        ", id=" + id +
        ", userId=" + userId +
        ", friendId=" + friendId +
        ", hasRead=" + hasRead +
        ", message=" + message +
        ", reateTime=" + reateTime +
        "}";
    }
}
