package cn.zdxh.invitation.controller;


import cn.zdxh.commons.pojo.Page;
import cn.zdxh.commons.entity.TComment;
import cn.zdxh.commons.utils.PageUtils;
import cn.zdxh.commons.utils.Result;
import cn.zdxh.commons.utils.WebRuntimeException;
import cn.zdxh.invitation.service.TCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
@Api(tags = "评论表")
@RestController
@RequestMapping("/tComment")
@Slf4j
public class TCommentController {

    @Autowired
    private TCommentService tCommentService;

    @ApiOperation("保存评论")
    @PostMapping("/save")
    public Result save(@RequestBody TComment tComment){
        Result result = new Result();
        try {
            boolean res = false;
            if (tComment.getId() != null){
                //修改
                res = tCommentService.updateById(tComment);
            }else {
                //新增
                res = tCommentService.save(tComment);
            }

            if (res){
                result.success("保存评论成功");
                return result;
            }
        }catch (Exception e){
            log.error(e.getMessage());
            throw new WebRuntimeException("保存评论失败");
        }
        return result;
    }

    @ApiOperation("查询评论")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable("id") Integer id){
        Result result = new Result();
        TComment tComment = tCommentService.getById(id);
        result.success(tComment);
        return result;
    }

    @ApiOperation("查询所有评论")
    @PostMapping("/gets")
    public Result getAll(@RequestBody TComment tComment,
                         @RequestParam(value = "currentPage",required = false) Integer currentPage,
                         @RequestParam(value = "pageSize",required = false) Integer pageSize
    ){
        //封装操作
        Result result = new Result();
        Map<String,Object> map = new HashMap<>();
        Page page = new Page(currentPage,pageSize);
        map.put("tComment",tComment);
        map.put("page", PageUtils.initStart(page));
        //查询操作
        List<TComment> tCommentList = tCommentService.findAllByComment(map);
        result.success(tCommentList);
        return result;
    }

    @ApiOperation("删除评论")
    @GetMapping("/del/{id}")
    public Result delete(@PathVariable("id") Integer id){
        Result result = new Result();
        try {
            boolean res = tCommentService.removeById(id);
            if (res){
                result.success("删除评论成功");
                return result;
            }
        }catch (Exception e){
            log.error(e.getMessage());
            throw new WebRuntimeException("删除评论失败");
        }
        return result;
    }
}

