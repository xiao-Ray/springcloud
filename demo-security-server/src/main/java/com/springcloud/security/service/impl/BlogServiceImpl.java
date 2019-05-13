package com.springcloud.security.service.impl;

import com.springcloud.commoncore.entity.Blog;
import com.springcloud.security.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("blogService")
public class BlogServiceImpl implements BlogService {

    private List<Blog> list=new ArrayList<>();

    @Override
    public List<Blog> getBlog() {
        list.add(new Blog(1L,"spring in action","good!"));
        list.add(new Blog(2L,"spring boot in action","nice!"));
        return list;
    }

    @Override
    public void deleteBlog(long id) {
        //迭代
        Iterator<Blog> iterator = list.iterator();
        while(iterator.hasNext()){
            Blog blog=iterator.next();
            if (blog.getId()==id){
                iterator.remove();
            }
        }
    }
}
