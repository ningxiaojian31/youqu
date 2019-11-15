package cn.zdxh.commons.form;

import cn.zdxh.commons.dto.TUserDTO;
import cn.zdxh.commons.entity.TUser;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 和前端交互对象，用户发送短信实体类
 */
public class TUserForm extends TUserDTO {
    //短信验证码
    @NotEmpty(message="验证码不允许为空")
    private String msgCode;

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }
}
