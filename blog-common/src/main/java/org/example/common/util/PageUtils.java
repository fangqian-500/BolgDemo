package org.example.common.util;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义分页
 * pageNO: 起始页
 * pageSize: 分页粒度
 * startNo: 查询起始位置  (pageNO-1)*pageSize
 */
@Data
@NoArgsConstructor
public class PageUtils {

    private static Integer pageNo;

    private static Integer pageSize;

    private static Integer startNO = (pageNo - 1)*pageSize;

//    public Integer getStartNO() {
//        return startNO = (pageNo-1)*pageSize;
//    }
}
