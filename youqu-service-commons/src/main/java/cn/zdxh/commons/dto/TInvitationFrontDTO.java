package cn.zdxh.commons.dto;

import lombok.Data;


/**
 * 帖子列表/前台
 * @author ningxj
 * @date 2020-1-31 11:48
 */
@Data
public class TInvitationFrontDTO  extends TInvitationDTO{

    private Integer userId;

    private String username;

    private String nickname;

    private String image;
}
