package cn.zdxh.commons.entity;

import lombok.Data;

/**
 * 分页实体类
 */
@Data
public class Page {
    //开始索引
    private Integer start;
    //当前页
    private Integer currentPage;
    //每页大小
    private Integer pageSize;
}
