package cn.zdxh.commons.dto;

import cn.zdxh.commons.entity.TComment;
import lombok.Data;

/**
 * @author ningxj
 * @date 2020-2-2 13:44
 */
@Data
public class TCommentDTO extends TComment {

    private Integer userId;

    private String username;

    private String nickname;

    private String image;
}
