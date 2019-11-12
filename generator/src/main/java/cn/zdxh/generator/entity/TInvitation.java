package cn.zdxh.generator.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 帖子表
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
public class TInvitation extends Model<TInvitation> {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    /**
     * 帖子内容
     */
    private String invContent;
    /**
     * 帖子类型。图文1视频2
     */
    private Integer invType;
    /**
     * 帖子图片（可多张）
     */
    private String invImage;
    /**
     * 帖子视频
     */
    private String invVideo;
    /**
     * 话题id
     */
    private Integer topId;
    /**
     * 点赞数
     */
    private String invLaud;
    /**
     * 分享数
     */
    private String invShare;
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

    public String getInvContent() {
        return invContent;
    }

    public void setInvContent(String invContent) {
        this.invContent = invContent;
    }

    public Integer getInvType() {
        return invType;
    }

    public void setInvType(Integer invType) {
        this.invType = invType;
    }

    public String getInvImage() {
        return invImage;
    }

    public void setInvImage(String invImage) {
        this.invImage = invImage;
    }

    public String getInvVideo() {
        return invVideo;
    }

    public void setInvVideo(String invVideo) {
        this.invVideo = invVideo;
    }

    public Integer getTopId() {
        return topId;
    }

    public void setTopId(Integer topId) {
        this.topId = topId;
    }

    public String getInvLaud() {
        return invLaud;
    }

    public void setInvLaud(String invLaud) {
        this.invLaud = invLaud;
    }

    public String getInvShare() {
        return invShare;
    }

    public void setInvShare(String invShare) {
        this.invShare = invShare;
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
        return "TInvitation{" +
        ", id=" + id +
        ", invContent=" + invContent +
        ", invType=" + invType +
        ", invImage=" + invImage +
        ", invVideo=" + invVideo +
        ", topId=" + topId +
        ", invLaud=" + invLaud +
        ", invShare=" + invShare +
        ", createTime=" + createTime +
        "}";
    }
}
