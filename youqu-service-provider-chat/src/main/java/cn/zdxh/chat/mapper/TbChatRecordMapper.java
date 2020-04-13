package cn.zdxh.chat.mapper;

import cn.zdxh.commons.dto.TbChatRecordBackDTO;
import cn.zdxh.commons.entity.TbChatRecord;
import cn.zdxh.commons.pojo.TbChatRecordVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbChatRecordMapper {

    int insert(TbChatRecord record);

    TbChatRecord selectByPrimaryKey(String id);

    int updateByPrimaryKey(TbChatRecord record);

    List<TbChatRecordVO> findListByUserId(TbChatRecord record);

    List<TbChatRecord> findUnreadByUserId(TbChatRecord record);

    List<TbChatRecord> findAllByUserIdAndFriendId(TbChatRecord record);

    List findAllByChatRecord(Page page,@Param("chatRecord") TbChatRecordBackDTO chatRecord);
}