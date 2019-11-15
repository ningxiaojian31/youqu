package cn.zdxh.user.service;

import cn.zdxh.commons.dto.TUserDTO;

public interface IMessageProvider {
    public void send(TUserDTO tUserDTO);
}
