package cn.zdxh.commons.dto;

import cn.zdxh.commons.entity.TComment;
import lombok.Data;

/**
 * 后台评论列表包装类
 */
@Data
public class TCommentBackDTO extends TComment {

    private String username;

    private String invContent;
}
