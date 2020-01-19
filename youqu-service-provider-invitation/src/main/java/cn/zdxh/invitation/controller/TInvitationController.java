package cn.zdxh.invitation.controller;


import cn.zdxh.commons.dto.TInvitationDTO;
import cn.zdxh.commons.entity.TInvitation;
import cn.zdxh.commons.utils.PageUtils;
import cn.zdxh.commons.utils.Result;
import cn.zdxh.commons.utils.ResultHelper;
import cn.zdxh.commons.utils.WebRuntimeException;
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

    @ApiOperation("查询所有帖子")
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

    @ApiOperation("删除帖子")
    @DeleteMapping("/del/{id}")
    public Result delete(@PathVariable("id") Integer id){
        boolean res = tInvitationService.removeById(id);
        if (res){
            return ResultHelper.createSuccess("删除帖子成功");
        }
        return ResultHelper.createError("删除帖子失败");
    }
}

