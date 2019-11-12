package cn.zdxh.generator.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 话题表
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
public class TTopic extends Model<TTopic> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 话题名称
     */
    private String topName;
    /**
     * 话题备注
     */
    private String topNote;
    /**
     * 话题图标
     */
    private String topImage;
    /**
     * 创建时间
     */
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopName() {
        return topName;
    }

    public void setTopName(String topName) {
        this.topName = topName;
    }

    public String getTopNote() {
        return topNote;
    }

    public void setTopNote(String topNote) {
        this.topNote = topNote;
    }

    public String getTopImage() {
        return topImage;
    }

    public void setTopImage(String topImage) {
        this.topImage = topImage;
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
        return "TTopic{" +
        ", id=" + id +
        ", topName=" + topName +
        ", topNote=" + topNote +
        ", topImage=" + topImage +
        ", createTime=" + createTime +
        "}";
    }
}
