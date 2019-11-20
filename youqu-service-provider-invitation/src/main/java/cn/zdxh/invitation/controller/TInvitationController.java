package cn.zdxh.invitation.controller;


import cn.zdxh.commons.entity.Page;
import cn.zdxh.commons.entity.TInvitation;
import cn.zdxh.commons.utils.PageUtils;
import cn.zdxh.commons.utils.Result;
import cn.zdxh.commons.utils.WebRuntimeException;
import cn.zdxh.invitation.service.TInvitationService;
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
        Result result = new Result();
        try {
            boolean res = false;
            if (tInvitation.getId() != null){
                //修改
                res = tInvitationService.updateById(tInvitation);
            }else {
                //新增
                res = tInvitationService.save(tInvitation);
            }

            if (res){
                result.success("保存帖子成功");
                return result;
            }
        }catch (Exception e){
            log.error(e.getMessage());
            throw new WebRuntimeException("保存帖子失败");
        }
        return result;
    }

    @ApiOperation("查询帖子")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable("id") Integer id){
        Result result = new Result();
        TInvitation tInvitation = tInvitationService.getById(id);
        result.success(tInvitation);
        return result;
    }

    @ApiOperation("查询所有帖子")
    @PostMapping("/gets")
    public Result getAll(@RequestBody TInvitation tInvitation,
                         @RequestParam(value = "currentPage",required = false) Integer currentPage,
                         @RequestParam(value = "pageSize",required = false) Integer pageSize
    ){
        //封装操作
        Result result = new Result();
        Map<String,Object> map = new HashMap<>();
        Page page = new Page(currentPage,pageSize);
        map.put("tInvitation",tInvitation);
        map.put("page", PageUtils.initStart(page));
        //查询操作
        List<TInvitation> tInvitationList = tInvitationService.findAllByInvitation(map);
        result.success(tInvitationList);
        return result;
    }

    @ApiOperation("删除帖子")
    @GetMapping("/del/{id}")
    public Result delete(@PathVariable("id") Integer id){
        Result result = new Result();
        try {
            boolean res = tInvitationService.removeById(id);
            if (res){
                result.success("删除帖子成功");
                return result;
            }
        }catch (Exception e){
            log.error(e.getMessage());
            throw new WebRuntimeException("删除帖子失败");
        }
        return result;
    }
}

