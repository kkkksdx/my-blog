package com.blog.myblog.controller.admin;

import com.blog.myblog.service.TagService;
import com.blog.myblog.utils.PageQueryUtil;
import com.blog.myblog.utils.ResultGenerator;
import com.blog.myblog.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Description: TODO
 * @author: Li
 * @date: 2022年03月01日 19:24
 */
@Controller
@RequestMapping("/admin")
public class TagController {

    @Resource
    private TagService tagService;

    @GetMapping("/tags")
    public String tagPage(HttpServletRequest request){
        request.setAttribute("path","tags");
        return "admin/tag";
    }

    @GetMapping("/tags/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params){
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(tagService.getBlogTagPage(pageUtil));
    }

    @PostMapping("/tags/delete")
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids){
        if(ids.length <1){
            return ResultGenerator.genFailResult("参数异常");
        }
        if(tagService.deleteBatch(ids)){
            return ResultGenerator.genSuccessResult();
        }else{
            return ResultGenerator.genFailResult("有关联数据，请勿删除");
        }
    }

    @PostMapping("/tags/save")
    @ResponseBody
    public Result save(@RequestParam("tagName") String tagName){
        if(StringUtils.isEmpty(tagName)){
            return ResultGenerator.genFailResult("参数异常");
        }
        if(tagService.saveTag(tagName)){
            return ResultGenerator.genSuccessResult();
        }else{
            return ResultGenerator.genFailResult("标签名重复");
        }
    }
}
