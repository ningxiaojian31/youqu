package cn.zdxh.other.log.mapper;

import cn.zdxh.commons.entity.SysLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统日志表 Mapper 接口
 * </p>
 *
 * @author Justin
 * @since 2020-04-10
 */
public interface SysLogMapper extends BaseMapper<SysLog> {

   List<SysLog> findAllBySysLog(Page page,@Param("sysLog") SysLog sysLog);

}
