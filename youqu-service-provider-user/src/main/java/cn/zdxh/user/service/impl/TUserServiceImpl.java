package cn.zdxh.user.service.impl;

import cn.zdxh.commons.entity.TUser;
import cn.zdxh.user.mapper.TUserMapper;
import cn.zdxh.user.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
