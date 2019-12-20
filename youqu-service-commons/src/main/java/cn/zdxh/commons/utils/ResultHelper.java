package cn.zdxh.commons.utils;

/**
 * 返回结果-辅助类
 */
public class ResultHelper {

    public static Result createSuccess(Object obj){
        Result result = new Result();
        result.success(obj);
        return result;
    }

    public static Result createSuccess(Object obj,String msg){
        Result result = new Result();
        result.success(obj,msg);
        return result;
    }

    public static Result createError(){
        Result result = new Result();
        result.error();
        return result;
    }

    public static Result createError(Object obj){
        Result result = new Result();
        result.error(obj);
        return result;
    }

    public static Result createUnauthorizedError(Object obj){
        Result result = new Result();
        result.setCode(-1);
        result.setMsg("失败");
        result.setData(obj);
        return result;
    }
}
