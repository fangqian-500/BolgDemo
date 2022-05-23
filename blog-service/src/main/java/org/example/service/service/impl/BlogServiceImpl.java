package org.example.service.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.service.domain.Blog;
import org.example.service.mapper.BlogMapper;
import org.example.service.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public  class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    /**
     * 添加博客的相关逻辑
     * @param blog
     * @return
     */
    @Override
    public Integer addBlog(Blog blog) {
        Integer integer = blogMapper.addBlog(blog);
        return integer;
    }

    @Override
    public Integer deleteBlogById(Integer id) {
        Integer integer = blogMapper.deleteBlogById(id);
        return integer;
    }

    @Override
    public Integer updateBlogById(Blog blog) {
        Integer integer = blogMapper.updateBlogById(blog);
        return integer;
    }

    @Override
    public List<Blog> findBlogList() {
        List<Blog> list = blogMapper.findBlogList();
        return list;
    }

    @Override
    public List<Blog> findBlogListByPage(String pageNo) {
        log.debug("分页测试");
        Integer startNo = (Integer.valueOf(pageNo)-1)*2;
        List<Blog> list = blogMapper.findBlogListByPage(startNo);

        return list;
    }


}
