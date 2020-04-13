package cn.zdxh.commons.dto;

import cn.zdxh.commons.entity.TInvitation;
import lombok.Data;

@Data
public class TInvitationDTO extends TInvitation {
    //话题名字
    private String topName;
    //审核状态
    private String invStatusName;
}
