package cn.zdxh.invitation.utils;

import cn.zdxh.commons.entity.SysLog;
import cn.zdxh.commons.utils.JwtUtils;
import cn.zdxh.commons.utils.SystemLog;
import cn.zdxh.commons.utils.SystemLogEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect
@Slf4j
public class SysLogAspect {

    @Autowired
    MqStream stream;

    //切点
    @Pointcut("@annotation(cn.zdxh.commons.utils.SystemLog)")
    public void logPointcut(){}

    //后置通知
    @After("logPointcut()")
    public void afterLog(JoinPoint joinPoint) {
        //一般日志
        SysLog sysLog = wrapSysLog(joinPoint);

        log.info("Log值："+sysLog);

        //发送mq消息
        stream.logOutput().send(MessageBuilder.withPayload(sysLog).build());

    }

    //异常通知
    @AfterThrowing(value = "logPointcut()", throwing = "e")
    public void throwingLog(JoinPoint joinPoint, Exception e) {
        //异常日志
        SysLog sysLog = wrapSysLog(joinPoint);
        sysLog.setLogType(SystemLogEnum.THROW_LOG.getType());
        sysLog.setLogMessage(sysLog.getLogMessage()+"==="+e);

        log.info("异常Log值："+sysLog);

        //发送mq消息
        stream.logOutput().send(MessageBuilder.withPayload(sysLog).build());
    }

    /**
     * 封装SysLog对象
     * @param joinPoint
     * @return
     */
    public SysLog wrapSysLog(JoinPoint joinPoint){
        //获取请求响应对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        SysLog sysLog = new SysLog();

        //获取方法全路径
        String methodName = signature.getDeclaringTypeName()+"."+signature.getName();
        //获取注解参数值
        SystemLog systemLog = signature.getMethod().getAnnotation(SystemLog.class);
        //从header取出token
        String token = request.getHeader("token");
        if (!StringUtils.isEmpty(token)) {
            //操作人信息
            Integer userId = JwtUtils.getUserId(token);
            String username = JwtUtils.getUsername(token);
            sysLog.setOptId(userId);
            sysLog.setOptName(username);
        }
        if (!StringUtils.isEmpty(systemLog.type())){
            sysLog.setLogType(systemLog.type().getType());
        }
        sysLog.setLogMessage(methodName);
        sysLog.setCreateTime(new Date());
        return sysLog;
    }

}
