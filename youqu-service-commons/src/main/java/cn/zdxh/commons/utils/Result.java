package cn.zdxh.commons.utils;

/**
 * web返回参数
 */
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public void success(T t){
        this.code = 1;
        this.msg = "成功";
        this.data = t;
    }

    public void success(T t,String msg){
        this.code = 1;
        this.msg = msg;
        this.data = t;
    }

    public void error(){
        this.code = 0;
        this.msg = "失败";
    }

    public void error(T t){
        this.code = 0;
        this.msg = "失败";
        this.data = t;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
