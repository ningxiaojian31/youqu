package cn.zdxh.commons.dto;

import cn.zdxh.commons.entity.TbChatRecord;
import lombok.Data;

@Data
public class TbChatRecordBackDTO extends TbChatRecord {

    //消息发送方
    private String senderName;

    //消息接收方
    private String receiverName;
}
