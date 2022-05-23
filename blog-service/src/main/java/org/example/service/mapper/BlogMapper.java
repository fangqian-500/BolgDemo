package org.example.service.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.service.domain.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {

    Integer addBlog(@Param("blog") Blog blog);

    Integer deleteBlogById(Integer id);

    Integer updateBlogById(@Param("blog") Blog blog);

    List<Blog> findBlogList();

    List<Blog> findBlogListByPage(Integer startNo);
}
