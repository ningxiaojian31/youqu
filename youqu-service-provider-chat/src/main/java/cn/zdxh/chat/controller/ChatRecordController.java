package cn.zdxh.chat.controller;


import cn.zdxh.chat.pojo.TbChatRecord;
import cn.zdxh.chat.pojo.TbChatRecordVO;
import cn.zdxh.chat.service.ChatRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chatrecord")
public class ChatRecordController {

    @Autowired
    private ChatRecordService chatRecordService;

    @RequestMapping("/findByUserIdAndFriendId")
    public List<TbChatRecord> findByUserIdAndFriendId(String userid, String friendid) {
        try {
            return chatRecordService.findByUserIdAndFriendId(userid, friendid);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<TbChatRecord>();
        }
    }

    @RequestMapping("/findListByUserId")
    public List<TbChatRecordVO> findListByUserId(String userid) {
        try {
            return chatRecordService.findListByUserId(userid);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<TbChatRecordVO>();
        }
    }
}
