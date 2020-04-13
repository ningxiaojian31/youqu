package cn.zdxh.invitation.service;

import cn.zdxh.commons.dto.TCommentBackDTO;
import cn.zdxh.commons.entity.TComment;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
public interface TCommentService extends IService<TComment> {

    int saveEntity(TComment tComment);

    Page findAllByComment(Page page, TCommentBackDTO tComment);
}
