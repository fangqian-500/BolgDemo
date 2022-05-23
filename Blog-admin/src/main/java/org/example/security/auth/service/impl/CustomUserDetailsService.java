package org.example.security.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.example.common.bo.PermissionInfoBO;
import org.example.security.auth.entity.RoleInfo;
import org.example.security.auth.entity.UserDetail;
import org.example.security.auth.entity.UserInfo;
import org.example.security.auth.service.PermissionService;
import org.example.security.auth.service.RoleInfoService;
import org.example.security.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleInfoService roleInfoService;

    @Autowired
    private PermissionService permissionService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.debug("开始登陆验证，用户名为: {}", s);

        // 根据用户名验证用户
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfo::getUsername, s);
        UserInfo userInfo = userService.getOne(queryWrapper);
        if (userInfo == null) {
            throw new UsernameNotFoundException("用户名不存在，登陆失败。");
        }

        // 构建UserDetail对象
        UserDetail userDetail = new UserDetail();
        userDetail.setUserInfo(userInfo);
        List<RoleInfo> roleInfoList = roleInfoService.listRoleByUserId(userInfo.getId());
        userDetail.setRoleInfoList(roleInfoList);

        //动态路由查询
        List<PermissionInfoBO> permissionInfoList = listTreePermissionByUserId(userInfo.getId());
        userDetail.setPermissionInfoList(permissionInfoList);
        return userDetail;
    }

    /**
     * 根据用户id查询出相关用户的所有菜单权限
     * @param id
     * @return
     */
    private List<PermissionInfoBO> listTreePermissionByUserId(String id) {
        //根据用户id查询出角色中所有的路由信息
        List<PermissionInfoBO> permissionInfoBOS = permissionService.listPermissionInfoBO();
        //根据parentId使用递归的方式构建树结构
        List<PermissionInfoBO> permissionInfoBOList = buildPermissionTree(permissionInfoBOS,"0");
        return permissionInfoBOList;
    }

    /**
     * 递归处理形成树形结构的菜单数据
     * @param permissionInfoBOS 用户所有的菜单权限集合
     * @param i
     * @return
     */
    private List<PermissionInfoBO> buildPermissionTree(List<PermissionInfoBO> permissionInfoBOS, String i) {
        List<PermissionInfoBO> list = new ArrayList<>();
        //递归入口集合
        for (PermissionInfoBO permissionInfoBO: permissionInfoBOS){
            if (permissionInfoBO.getParentId().equals(i)){
                list.add(permissionInfoBO);
            }
        }
        //递归
        for (PermissionInfoBO permissionInfoBO1:list){
            List<PermissionInfoBO> permissionInfoBOList = buildPermissionTree(permissionInfoBOS, permissionInfoBO1.getId());
            permissionInfoBO1.setChildPermissionBo(permissionInfoBOList);
        }

        return list;
    }

}
