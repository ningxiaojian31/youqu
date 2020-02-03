package cn.zdxh.commons.dto;

import cn.zdxh.commons.entity.TUser;
import lombok.Data;

import java.util.Date;

/**
 * 用户详情/前台
 * @author ningxj
 * @date 2020-2-3 20:42
 */
@Data
public class TUserDetailDTO {

    private Integer id;

    private String username;

    private String nickname;

    private String image;

    private Integer sex;

    private Date birthday;

    private String signature;

    //粉丝
    private Integer fans;

    //关注
    private Integer focus;

}
