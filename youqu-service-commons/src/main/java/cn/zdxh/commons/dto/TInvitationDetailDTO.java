package cn.zdxh.commons.dto;

import cn.zdxh.commons.entity.TInvitation;
import lombok.Data;

import java.util.List;

/**
 * 帖子详情/前台
 * @author ningxj
 * @date 2020-2-1 10:26
 */
@Data
public class TInvitationDetailDTO extends TInvitation {
    //评论
    List<TCommentDTO> commentList;
}
