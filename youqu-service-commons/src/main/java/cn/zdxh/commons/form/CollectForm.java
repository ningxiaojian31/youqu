package cn.zdxh.commons.form;

import lombok.Data;

/**
 * 收藏实体类
 * @author ningxj
 * @date 2020-2-3 9:55
 */
@Data
public class CollectForm {
    /**
     * 收藏用户，作为key
     * 示例
     * 帖子：collect-inv-具体的帖子Id
     */
    private String userId;

     //收藏实体Id,作为value
    private Integer poId;
}
