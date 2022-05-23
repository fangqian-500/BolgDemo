package org.example.service.service;

import org.example.common.util.PageUtils;
import org.example.service.domain.Blog;

import java.util.List;

public interface BlogService {
    Integer addBlog(Blog blog);

    Integer deleteBlogById(Integer id);

    Integer updateBlogById(Blog blog);

    List<Blog> findBlogList();

    List<Blog> findBlogListByPage(String pageNO);
}
