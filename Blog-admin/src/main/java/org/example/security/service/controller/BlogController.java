package org.example.security.service.controller;

import org.example.common.bo.ApiResult;
import org.example.service.domain.Blog;
import org.example.service.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BlogController {

    @Resource
    private BlogService blogService;

    //添加博客
    @PostMapping("add")
    public ApiResult addBlog(@RequestBody Blog blog){
        Integer integer = blogService.addBlog(blog);
        return ApiResult.ok(integer);
    }

    //删除博客
    @GetMapping("delete")
    public ApiResult deleteBlog(@RequestParam Integer id){
        Integer integer = blogService.deleteBlogById(id);
        return ApiResult.ok(integer);
    }


    //更新博客
    @PostMapping("update")
    public ApiResult updateBlog(@RequestBody Blog blog){
        Integer integer = blogService.updateBlogById(blog);
        return ApiResult.ok(integer);
    }


    //查询博客
    @GetMapping("getAllBlog")
    public ApiResult getAllBlog(){
        List<Blog> blogList = blogService.findBlogList();
        return ApiResult.ok(blogList);
    }

    @GetMapping("getBlogListByPage")
    public ApiResult getBlogListByPage(@RequestParam String pageNo){
        List<Blog> list = blogService.findBlogListByPage(pageNo);
        return ApiResult.ok(list);
    }

}
