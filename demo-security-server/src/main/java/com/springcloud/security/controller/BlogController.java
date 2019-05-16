package com.springcloud.security.controller;

import com.springcloud.commoncore.entity.Blog;
import com.springcloud.commoncore.entity.Result;
import com.springcloud.security.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/blog/")
public class BlogController {

    @Autowired
    private BlogService blogService;

    //list列表查询
    @RequestMapping("list")
    public String list(Model model){
        List<Blog> list = blogService.getBlog();
        model.addAttribute("list",list);
        return "blog/list";
    }

    //删除
    @GetMapping("{id}/deletion")
    @PreAuthorize("hasAuthority('ROLE_USER')")  //在调用方法之前进行验证,判断是否有USER的ROLE
    @ResponseBody
    public Result delete(@PathVariable("id")Long id){
        int i = blogService.deleteBlog(id);

        if (i==1){
            return new Result(200,"删除成功");
        }
        return new Result(0,"删除失败");
    }


}
