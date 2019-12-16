package cn.zdxh.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局同一异常管理
 */
@ControllerAdvice
public class WebExceptionResolver {
    private static final Logger LOG = LoggerFactory.getLogger(WebExceptionResolver.class);

    /**
     * 处理所有不可知异常
     *
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleException(Exception e) {
        // 打印异常堆栈信息
        LOG.error(e.getMessage(), e);
        return ResultHelper.createError(e.getMessage());
    }

}
