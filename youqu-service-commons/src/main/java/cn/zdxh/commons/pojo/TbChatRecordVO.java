package cn.zdxh.commons.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TbChatRecordVO {
    private String id;

    private String userid;

    private String friendid;

    private Integer hasRead;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    private Integer hasDelete;

    private String message;

    private String nickname;

    private String username;

    private String image;


}