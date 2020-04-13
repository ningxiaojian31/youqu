package cn.zdxh.other.log.mq;

import cn.zdxh.commons.entity.SysLog;
import cn.zdxh.other.log.mapper.SysLogMapper;
import cn.zdxh.other.log.service.SysLogService;
import cn.zdxh.other.utils.MqStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * 监听日志
 */
@Service
@Slf4j
public class LogMqListener {

    @Autowired
    SysLogService sysLogService;

    @StreamListener(MqStream.LOG_INPUT)
    public void input(SysLog sysLog)  {
        log.info("开始记录日志========================");

        sysLogService.save(sysLog);

        log.info("结束记录日志========================");

    }
}
