package cn.zdxh.chat.controller;


import cn.zdxh.chat.service.ChatRecordService;
import cn.zdxh.commons.dto.TbChatRecordBackDTO;
import cn.zdxh.commons.entity.TbChatRecord;
import cn.zdxh.commons.pojo.TbChatRecordVO;
import cn.zdxh.commons.utils.Result;
import cn.zdxh.commons.utils.ResultHelper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chatrecord")
public class ChatRecordController {

    @Autowired
    private ChatRecordService chatRecordService;

    @ApiOperation("查询当前聊天记录/前台")
    @RequestMapping("/findByUserIdAndFriendId")
    public List<TbChatRecord> findByUserIdAndFriendId(String userid, String friendid) {
        try {
            return chatRecordService.findByUserIdAndFriendId(userid, friendid);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<TbChatRecord>();
        }
    }

    @ApiOperation("查询聊天记录列表/前台")
    @RequestMapping("/findListByUserId")
    public List<TbChatRecordVO> findListByUserId(String userid) {
        try {
            return chatRecordService.findListByUserId(userid);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<TbChatRecordVO>();
        }
    }

    @ApiOperation("查询所有聊天记录")
    @PostMapping("/list")
    public Result list(@RequestBody TbChatRecordBackDTO chatRecord,
                       @RequestParam(value = "currentPage",required = false) Integer currentPage,
                       @RequestParam(value = "pageSize",required = false) Integer pageSize){
        Page page = new Page();
        page.setCurrent(currentPage != null ? currentPage : 1);
        page.setSize(pageSize != null ? pageSize : 10);
        return ResultHelper.createSuccess(chatRecordService.findAllByChatRecord(page,chatRecord));
    }
}
