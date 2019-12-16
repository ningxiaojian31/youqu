package cn.zdxh.invitation.service;

import cn.zdxh.commons.entity.TTopic;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 话题表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
public interface TTopicService extends IService<TTopic> {

    int saveEntity(TTopic tTopic);

    Page findAllByTopic(Page page, TTopic tTopic);
}
