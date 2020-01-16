package cn.zdxh.user.service;

import cn.zdxh.commons.dto.TUserDTO;
import cn.zdxh.commons.entity.TUser;
import cn.zdxh.commons.form.TUserForm;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
public interface TUserService extends IService<TUser> {

    void sendMsg(TUserDTO tUserDTO);

    TUserForm register(TUserForm tUserForm);

    TUser login(TUserDTO tUserDTO);

    List<TUser> findAll();
}
