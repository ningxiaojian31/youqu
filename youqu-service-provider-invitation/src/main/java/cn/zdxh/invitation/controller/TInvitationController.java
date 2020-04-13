package cn.zdxh.invitation.controller;


import cn.zdxh.commons.dto.TInvitationDTO;
import cn.zdxh.commons.dto.TInvitationDetailDTO;
import cn.zdxh.commons.dto.TInvitationFrontDTO;
import cn.zdxh.commons.entity.TInvitation;
import cn.zdxh.commons.form.CollectForm;
import cn.zdxh.commons.form.LaudForm;
import cn.zdxh.commons.utils.*;
import cn.zdxh.invitation.service.TInvitationService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
 * 帖子表 前端控制器
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
@Api(tags = "帖子表")
@RestController
@RequestMapping("/tInvitation")
@Slf4j
public class TInvitationController {

    @Autowired
    private TInvitationService tInvitationService;

    @SystemLog(type = SystemLogEnum.SAVE_LOG)
    @ApiOperation("保存帖子")
    @PostMapping("/save")
    public Result save(@RequestBody TInvitation tInvitation){
        int res = tInvitationService.saveEntity(tInvitation);
        if (res > 0){
            return ResultHelper.createSuccess("发布帖子成功");
        }
        return ResultHelper.createError("发布帖子失败");
    }

    @ApiOperation("查询帖子")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable("id") Integer id){
        TInvitation tInvitation = tInvitationService.getById(id);
        return ResultHelper.createSuccess(tInvitation);
    }

    @ApiOperation("查询帖子详情/前台")
    @GetMapping("/front/get/{id}")
    public Result frontGet(@PathVariable("id") Integer id){
        TInvitationDetailDTO tInvitation = tInvitationService.findByIdOnFront(id);
        return ResultHelper.createSuccess(tInvitation);
    }

    @ApiOperation("查询所有帖子/后台")
    @PostMapping("/list")
    public Result list(@RequestBody TInvitationDTO tInvitationDTO,
                         @RequestParam(value = "currentPage",required = false) Integer currentPage,
                         @RequestParam(value = "pageSize",required = false) Integer pageSize){
        //分页查询
        Page page = new Page();
        page.setCurrent(currentPage != null ? currentPage : 1);
        page.setSize(pageSize != null ? pageSize : 10);
        return ResultHelper.createSuccess(tInvitationService.findAllByInvitation(page,tInvitationDTO));
    }

    @ApiOperation("查询所有帖子/前台")
    @GetMapping("/front/list")
    public Result frontList(@RequestParam(value = "currentPage",required = false) Integer currentPage,
                       @RequestParam(value = "pageSize",required = false) Integer pageSize){
        //分页查询
        Page page = new Page<TInvitationFrontDTO>();
        page.setCurrent(currentPage != null ? currentPage : 1);
        page.setSize(pageSize != null ? pageSize : 10);
        return ResultHelper.createSuccess(tInvitationService.findAllByInvitationOnFront(page));
    }

    @SystemLog(type = SystemLogEnum.DELETE_LOG)
    @ApiOperation("删除帖子")
    @DeleteMapping("/del/{id}")
    public Result delete(@PathVariable("id") Integer id){
        boolean res = tInvitationService.removeById(id);
        if (res){
            return ResultHelper.createSuccess("删除帖子成功");
        }
        return ResultHelper.createError("删除帖子失败");
    }

    @SystemLog(type = SystemLogEnum.LAUD_LOG)
    @ApiOperation("点赞/只允许点赞一次")
    @PostMapping("/laud/add")
    public Result addLaud(@RequestBody LaudForm laudForm){
        tInvitationService.addLaud(laudForm);
        return ResultHelper.createSuccess("只能点赞一次哦！");
    }

    @ApiOperation("点赞总数")
    @GetMapping("/laud/count/{poId}")
    public Result countLaud(@PathVariable String poId){
        return ResultHelper.createSuccess(tInvitationService.countLaud(poId));
    }

    @SystemLog(type = SystemLogEnum.COLLECT_LOG)
    @ApiOperation("收藏")
    @PostMapping("/collect/add")
    public Result addCollect(@RequestBody CollectForm collectForm){
        tInvitationService.addCollect(collectForm);
        return ResultHelper.createSuccess("收藏成功");
    }

    @ApiOperation("取消收藏")
    @PostMapping("/collect/move")
    public Result moveCollect(@RequestBody CollectForm collectForm){
        tInvitationService.moveCollect(collectForm);
        return ResultHelper.createSuccess("取消收藏成功");
    }

    @ApiOperation("是否收藏")
    @PostMapping("/collect/or")
    public Result orCollect(@RequestBody CollectForm collectForm){
        return ResultHelper.createSuccess(tInvitationService.orCollect(collectForm));
    }

    @ApiOperation("查询收藏帖子/前台")
    @GetMapping("/front/collect/list")
    public Result collectList(@RequestParam(value = "userId",required = true) Integer userId,
                       @RequestParam(value = "currentPage",required = false) Integer currentPage,
                       @RequestParam(value = "pageSize",required = false) Integer pageSize){
        //分页查询
        Page page = new Page();
        page.setCurrent(currentPage != null ? currentPage : 1);
        page.setSize(pageSize != null ? pageSize : 10);
        return ResultHelper.createSuccess(tInvitationService.findCollectAllByUserId(page,userId));
    }

}

