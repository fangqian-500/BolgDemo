package org.example.service.domain;

import com.alibaba.druid.sql.PagerUtils;
import lombok.Data;
import org.jboss.logging.Field;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
public class Blog {
    
    private Integer id;
    //标题
    private String title;

    //分类（字典）
    private String blogType;

    //作者
    private String author;

    private String views;//阅览量

    private Date publishTime;//发布时间

    private String commnet;//评论

    private String support;//点赞

    private String focus;//关注

    private String article;//文章

    private String  activeStatus;//0 可用  1 不可用
}
