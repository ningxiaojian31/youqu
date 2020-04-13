package cn.zdxh.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 系统日志表
 * </p>
 *
 * @author Justin
 * @since 2020-04-10
 */
@Data
public class SysLog  {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 操作用户id
     */
    private Integer optId;
    /**
     * 操作用户名
     */
    private String optName;
    /**
     * 日志类型
     */
    private String logType;
    /**
     * 日志信息（具体方法名）
     */
    private String logMessage;
    /**
     * 创建时间
     */
    private Date createTime;

}
