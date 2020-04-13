package cn.zdxh.other.log.service;


import cn.zdxh.commons.entity.SysLog;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统日志表 服务类
 * </p>
 *
 * @author Justin
 * @since 2020-04-10
 */
public interface SysLogService extends IService<SysLog> {

    Page findAllBySysLog(Page page, SysLog sysLog);
}
