package cn.zdxh.invitation.service.impl;

import cn.zdxh.commons.entity.TComment;
import cn.zdxh.invitation.mapper.TCommentMapper;
import cn.zdxh.invitation.service.TCommentService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


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
    public int saveEntity(TComment tComment) {
        int res = 0;
        if (tComment.getId() != null){
            res = tCommentMapper.updateById(tComment);
        }else {
            tComment.setCreateTime(new Date());
            res = tCommentMapper.insert(tComment);
        }
        return res;
    }

    @Override
    public Page findAllByComment(Page page, TComment tComment) {
        page.setRecords(tCommentMapper.findAllByComment(page,tComment));
        return page;
    }
}
