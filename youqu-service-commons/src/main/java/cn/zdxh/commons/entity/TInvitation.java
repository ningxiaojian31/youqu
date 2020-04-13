package cn.zdxh.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 帖子表
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
@Data
public class TInvitation extends Model<TInvitation> {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
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
     * 用户id
     */
    private Integer userId;
    /**
     * 点赞数
     */
    private String invLaud;
    /**
     * 分享数
     */
    private String invShare;
    /**
     * 收藏数
     */
    private String invCollect;
    /**
     * 审核状态
     */
    private Integer invStatus;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;


}
