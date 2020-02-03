package cn.zdxh.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

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
@Data
public class TComment extends Model<TComment> {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

}
