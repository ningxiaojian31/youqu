package cn.zdxh.chat.service.impl;

import cn.zdxh.chat.mapper.TbChatRecordMapper;
import cn.zdxh.chat.service.ChatRecordService;
import cn.zdxh.chat.util.IdWorker;
import cn.zdxh.commons.dto.TbChatRecordBackDTO;
import cn.zdxh.commons.entity.TbChatRecord;
import cn.zdxh.commons.pojo.TbChatRecordVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ChatRecordServiceImpl implements ChatRecordService {

    @Autowired
    private TbChatRecordMapper chatRecordMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public void insert(TbChatRecord chatRecord) {
        chatRecord.setId(idWorker.nextId());
        chatRecord.setHasRead(0);
        chatRecord.setCreatetime(new Date());
        chatRecord.setHasDelete(0);

        chatRecordMapper.insert(chatRecord);
    }

    /**
     * 1、将 userid -> friendid的聊天记录查询出来
     * 2、将 friendid -> userid的聊天记录查询出来
     */
    @Override
    public List<TbChatRecord> findByUserIdAndFriendId(String userid, String friendid) {

        TbChatRecord recordReq = new TbChatRecord();
        recordReq.setUserid(userid);
        recordReq.setFriendid(friendid);
        recordReq.setHasRead(0);

        // 将发给userid的所有聊天记录设置为已读
        List<TbChatRecord> tbChatRecords = chatRecordMapper.findUnreadByUserId(recordReq);
        for (TbChatRecord tbChatRecord : tbChatRecords) {
            tbChatRecord.setHasRead(1);
            chatRecordMapper.updateByPrimaryKey(tbChatRecord);
        }


        return chatRecordMapper.findAllByUserIdAndFriendId(recordReq);
    }

    @Override
    public List<TbChatRecordVO> findListByUserId(String userid) {
        TbChatRecord record = new TbChatRecord();
        record.setUserid(userid);

        List<TbChatRecordVO> list = chatRecordMapper.findListByUserId(record);
        //去重,每组最多两条重复
        for (int i = 0; i < list.size(); i ++){
            for (int j = i + 1; j < list.size(); j ++){
                if ((list.get(i).getUserid().equals(list.get(j).getFriendid())) &&
                        (list.get(i).getFriendid().equals(list.get(j).getUserid()))){
                    if (list.get(i).getCreatetime().getTime() > list.get(j).getCreatetime().getTime()){
                        list.remove(j);
                    }else {
                        list.remove(i);
                    }
                    break;
                }
            }
        }

        return list;
    }

    @Override
    public void updateStatusHasRead(String id) {
        TbChatRecord tbChatRecord = chatRecordMapper.selectByPrimaryKey(id);
        tbChatRecord.setHasRead(1);

        chatRecordMapper.updateByPrimaryKey(tbChatRecord);
    }

    @Override
    public Page findAllByChatRecord(Page page, TbChatRecordBackDTO chatRecord) {
        page.setRecords(chatRecordMapper.findAllByChatRecord(page,chatRecord));
        return page;
    }
}
