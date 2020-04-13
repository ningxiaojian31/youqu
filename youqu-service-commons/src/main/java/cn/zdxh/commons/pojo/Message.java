package cn.zdxh.commons.pojo;

import cn.zdxh.commons.entity.TbChatRecord;
import lombok.Data;

/**
 * netty聊天实体类
 */
@Data
public class Message {
    private Integer type; // 消息类型
    private TbChatRecord tChatRecord;    // 聊天消息
    private Object ext;  // 扩展消息字段

}
