package cn.zdxh.chat.mapper;

import cn.zdxh.chat.pojo.TbChatRecord;
import cn.zdxh.chat.pojo.TbChatRecordVO;

import java.util.List;

public interface TbChatRecordMapper {

    int insert(TbChatRecord record);

    TbChatRecord selectByPrimaryKey(String id);

    int updateByPrimaryKey(TbChatRecord record);

    List<TbChatRecordVO> findListByUserId(TbChatRecord record);

    List<TbChatRecord> findUnreadByUserId(TbChatRecord record);

    List<TbChatRecord> findAllByUserIdAndFriendId(TbChatRecord record);
}