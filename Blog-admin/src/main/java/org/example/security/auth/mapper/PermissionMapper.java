package org.example.security.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.common.bo.PermissionInfoBO;
import org.example.security.auth.entity.PermissionInfo;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 和耳朵
 * @since 2020-06-30
 */
public interface PermissionMapper extends BaseMapper<PermissionInfo> {

    List<PermissionInfoBO> listPermissionInfoBO();

}
