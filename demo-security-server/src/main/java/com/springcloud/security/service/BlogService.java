package com.springcloud.security.service;

import com.springcloud.commoncore.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> getBlog();

    void  deleteBlog(long id);
}
