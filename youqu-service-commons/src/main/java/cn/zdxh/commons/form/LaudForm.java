package cn.zdxh.commons.form;

import lombok.Data;

/**
 * 点赞实体类
 * @author ningxj
 * @date 2020-2-2 20:53
 */
@Data
public class LaudForm {
    //用户ID，作为value
    private Integer userId;
    /**
     * 帖子、评论ID,作为key
     * 示例：
     * 帖子：laud-inv-具体帖子ID
     * 评论：laud-com-具体帖子ID-具体评论ID
     */
    private String poId;
}
