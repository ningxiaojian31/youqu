package cn.zdxh.commons.utils;

import cn.zdxh.commons.pojo.Page;

/**
 * 分页工具类
 */
public class PageUtils {

    //计算开始索引
    public static Page initStart(Page page){
        Page result = new Page();
        if (page.getCurrentPage() == null || page.getPageSize() == null
            || page.getCurrentPage() < 0 || page.getPageSize() < 0){
            result.setCurrentPage(1);
            result.setStart(0); //从零开始
            result.setPageSize(10); //默认前面10条数据
        }else {
            result.setCurrentPage(page.getCurrentPage());
            result.setPageSize(page.getPageSize());
            Integer start = (page.getCurrentPage() - 1) * page.getPageSize();
            result.setStart(start);
        }
        return result;
    }
}
