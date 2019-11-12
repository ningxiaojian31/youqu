package cn.zdxh.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
public class TComment extends Model<TComment> {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    /**
     * 评论内容
     */
    private String comContent;
    /**
     * 评论图片（可多张）
     */
    private String comImage;
    /**
     * 点赞数
     */
    private String comLaud;
    /**
     * 帖子id
     */
    private Integer invId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 创建时间
     */
    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public String getComImage() {
        return comImage;
    }

    public void setComImage(String comImage) {
        this.comImage = comImage;
    }

    public String getComLaud() {
        return comLaud;
    }

    public void setComLaud(String comLaud) {
        this.comLaud = comLaud;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TComment{" +
        ", id=" + id +
        ", comContent=" + comContent +
        ", comImage=" + comImage +
        ", comLaud=" + comLaud +
        ", invId=" + invId +
        ", userId=" + userId +
        ", createTime=" + createTime +
        "}";
    }
}
