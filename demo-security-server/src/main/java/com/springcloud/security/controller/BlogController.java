package com.springcloud.security.controller;

import com.springcloud.commoncore.entity.Blog;
import com.springcloud.security.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blog/")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("list")
    public String list(Model model){
        List<Blog> list = blogService.getBlog();
        model.addAttribute("list",list);
        return "blog/list";
    }

    @RequestMapping("{id}/deletion")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")  //在调用方法之前进行验证,判断是否有ADMIN的ROLE
    public String delete(@PathVariable("id")Long id){
        blogService.deleteBlog(id);
        return "redirect:/blog/list";
    }


}
