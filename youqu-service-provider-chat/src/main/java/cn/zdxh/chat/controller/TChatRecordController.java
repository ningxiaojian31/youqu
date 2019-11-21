package cn.zdxh.chat.controller;


import cn.zdxh.chat.service.TChatRecordService;
import cn.zdxh.commons.entity.TChatRecord;
import cn.zdxh.commons.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 聊天记录表 前端控制器
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
@Api(tags = "聊天记录")
@Controller
@RequestMapping("/tChatRecord")
public class TChatRecordController {

    @Autowired
    private TChatRecordService chatRecordService;

    /**
     * 查询当前聊天所有聊天记录
     * @param userId
     * @param friendId
     * @return
     */
    @ApiOperation("查询当前聊天所有聊天记录")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户ID",name = "userId",required = true,dataType = "int"),
            @ApiImplicitParam(value = "好友ID",name = "friendId",required = true,dataType = "int")
    })
    @RequestMapping("/findAll/{userId}/{friendId}")
    public Result findByUserIdAndFriendId(@PathVariable("userId") Integer userId,
                                          @PathVariable("friendId") Integer friendId) {
        Result result = new Result();
        try {
            List<TChatRecord> tChatRecordList = chatRecordService.findByUserIdAndFriendId(userId, friendId);
            result.success(tChatRecordList);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.error(e.getMessage());
            return result;
        }
    }

    /**
     * 查询所有未读记录
     * @param userId
     * @return
     */
    @ApiOperation("查询所有未读记录")
    @ApiImplicitParam(value = "用户ID",name = "userId",required = true,dataType = "int")
    @RequestMapping("/findUnread/{userId}")
    public Result findUnreadByUserid(@PathVariable("userId") Integer userId) {
        Result result = new Result();
        try {
            List<TChatRecord> tChatRecordList = chatRecordService.findUnreadByUserId(userId);
            result.success(tChatRecordList);
            return result;
        } catch (Exception e) {
            result.error(e.getMessage());
            return result;
        }
    }

}

