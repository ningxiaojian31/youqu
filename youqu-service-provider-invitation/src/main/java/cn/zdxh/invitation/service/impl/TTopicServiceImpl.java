package cn.zdxh.invitation.service.impl;

import cn.zdxh.commons.entity.TTopic;
import cn.zdxh.invitation.mapper.TTopicMapper;
import cn.zdxh.invitation.service.TTopicService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 话题表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
@Service
public class TTopicServiceImpl extends ServiceImpl<TTopicMapper, TTopic> implements TTopicService {

    @Autowired
    private TTopicMapper tTopicMapper;

    @Override
    public int saveEntity(TTopic tTopic) {
        int res = 0;
        if (tTopic.getId() != null){
            //修改
            res = tTopicMapper.updateById(tTopic);
        }else {
            tTopic.setCreateTime(new Date());
            res = tTopicMapper.insert(tTopic);
        }
        return res;
    }

    @Override
    public Page findAllByTopic(Page page, TTopic tTopic) {
        page.setRecords(tTopicMapper.findAllByTopic(page,tTopic));
        return page;
    }
}
