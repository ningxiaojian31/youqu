package cn.zdxh.commons.utils;

/**
 * 自定义异常
 */
public class WebRuntimeException extends RuntimeException{

    private String msg;

    public WebRuntimeException(String message) {
        super(message);
        this.msg = message;
    }


    public String getMsg() {
        return msg;
    }
}
