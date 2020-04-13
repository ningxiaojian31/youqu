package cn.zdxh.other.log.service.impl;


import cn.zdxh.commons.entity.SysLog;
import cn.zdxh.other.log.mapper.SysLogMapper;
import cn.zdxh.other.log.service.SysLogService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2020-04-10
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public Page findAllBySysLog(Page page, SysLog sysLog) {
        page.setRecords(sysLogMapper.findAllBySysLog(page,sysLog));
        return page;
    }
}
