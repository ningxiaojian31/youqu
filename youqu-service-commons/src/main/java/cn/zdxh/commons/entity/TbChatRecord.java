package cn.zdxh.commons.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TbChatRecord {
    private String id;

    private String userid;

    private String friendid;

    private Integer hasRead;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    private Integer hasDelete;

    private String message;


}