package cn.zdxh.chat.service;


import cn.zdxh.commons.dto.TbChatRecordBackDTO;
import cn.zdxh.commons.entity.TbChatRecord;
import cn.zdxh.commons.pojo.TbChatRecordVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface ChatRecordService {
    /**
     * 将聊天记录保存到数据库中
     * @param chatRecord
     */
    void insert(TbChatRecord chatRecord);

    /**
     * 根据用户id和好友id将聊天记录查询出来
     * @param userid 用户id
     * @param friendid 好友id
     * @return 聊天记录列表
     */
    List<TbChatRecord> findByUserIdAndFriendId(String userid, String friendid);

    /**
     * 查询聊天列表
     * @param userid 用户id
     * @return
     */
    List<TbChatRecordVO> findListByUserId(String userid);

    /**
     * 设置消息为已读
     * @param id 聊天记录的id
     */
    void updateStatusHasRead(String id);

    Page findAllByChatRecord(Page page, TbChatRecordBackDTO chatRecord);
}
