package cn.zdxh.chat.service.impl;

import cn.zdxh.chat.mapper.TChatRecordMapper;
import cn.zdxh.chat.service.TChatRecordService;
import cn.zdxh.commons.entity.TChatRecord;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 聊天记录表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
@Service
public class TChatRecordServiceImpl extends ServiceImpl<TChatRecordMapper, TChatRecord> implements TChatRecordService {

    @Autowired
    private TChatRecordMapper tChatRecordMapper;

    @Override
    public List<TChatRecord> findByUserIdAndFriendId(Integer userId, Integer friendId) {
        QueryWrapper<TChatRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("friend_id",friendId);
        List<TChatRecord> tChatRecordList = tChatRecordMapper.selectList(queryWrapper);
        return tChatRecordList;
    }

    @Override
    public List<TChatRecord> findUnreadByUserId(Integer userId) {
        QueryWrapper<TChatRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("has_read",0); //未读
        List<TChatRecord> tChatRecordList = tChatRecordMapper.selectList(queryWrapper);
        return tChatRecordList;
    }
}
