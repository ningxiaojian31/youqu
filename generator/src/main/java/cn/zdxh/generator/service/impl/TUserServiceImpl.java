package cn.zdxh.generator.service.impl;

import cn.zdxh.generator.entity.TUser;
import cn.zdxh.generator.mapper.TUserMapper;
import cn.zdxh.generator.service.TUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
