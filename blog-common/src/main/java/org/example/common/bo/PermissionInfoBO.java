package org.example.common.bo;

import lombok.Data;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author 和耳朵
 * @since 2020-07-05 19:05
 */
@Data
public class PermissionInfoBO {

    private String id;

    private String permissionName;

    private String permissionUri;

    private String permissionMethod;

    private String parentId;

    private String roleName;

    private String roleCode;

    private List<PermissionInfoBO> childPermissionBo;
}
