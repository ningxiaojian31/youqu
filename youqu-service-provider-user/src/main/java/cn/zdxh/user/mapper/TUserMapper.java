package cn.zdxh.user.mapper;

import cn.zdxh.commons.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
public interface TUserMapper extends BaseMapper<TUser> {

    List<TUser> findAll();

    List findAllByUser(Page page,@Param("tUser") TUser tUser);
}
