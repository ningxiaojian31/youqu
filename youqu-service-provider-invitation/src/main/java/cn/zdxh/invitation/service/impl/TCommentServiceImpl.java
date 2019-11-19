package cn.zdxh.invitation.service.impl;

import cn.zdxh.commons.entity.TComment;
import cn.zdxh.invitation.mapper.TCommentMapper;
import cn.zdxh.invitation.service.TCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
@Service
public class TCommentServiceImpl extends ServiceImpl<TCommentMapper, TComment> implements TCommentService {

    @Autowired
    private TCommentMapper tCommentMapper;

    @Override
    public List<TComment> findAllByComment(Map<String, Object> map) {
        return tCommentMapper.findAllByComment(map);
    }
}
