package cn.zdxh.chat.service;

import cn.zdxh.commons.entity.TChatRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 聊天记录表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
public interface TChatRecordService extends IService<TChatRecord> {

    List<TChatRecord> findByUserIdAndFriendId(Integer userId, Integer friendId);

    List<TChatRecord> findUnreadByUserId(Integer userId);
}
