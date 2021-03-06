package org.example.security.auth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.common.bo.AccessToken;
import org.example.common.bo.ApiResult;
import org.example.security.auth.cache.Cache;
import org.example.common.constant.CacheName;
import org.example.security.auth.entity.UserDetail;
import org.example.security.auth.provider.AuthProvider;
import org.example.security.auth.provider.JwtProvider;
import org.example.security.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private Cache caffeineCache;


    @Override
    public ApiResult login(String loginAccount, String password) {

        log.debug("进入login方法");
        // 1 创建UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken usernameAuthentication = new UsernamePasswordAuthenticationToken(loginAccount, password);
        // 2 认证
        Authentication authentication = this.authenticationManager.authenticate(usernameAuthentication);
        // 3 保存认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 4 生成自定义token
        AccessToken accessToken = jwtProvider.createToken((UserDetails) authentication.getPrincipal());

        UserDetail userDetail = (UserDetail) authentication.getPrincipal();
        userDetail.setToken(accessToken);
        // 放入缓存
        caffeineCache.put(CacheName.USER, userDetail.getUsername(), userDetail);
        //返回userDetail，对象封装了token
        return ApiResult.ok(userDetail);
//        return ApiResult.ok(accessToken);
    }

    @Override
    public ApiResult logout() {
        caffeineCache.remove(CacheName.USER, AuthProvider.getLoginAccount());
        SecurityContextHolder.clearContext();
        return ApiResult.ok();
    }

    @Override
    public ApiResult refreshToken(String token) {
        AccessToken accessToken = jwtProvider.refreshToken(token);
        UserDetail userDetail = caffeineCache.get(CacheName.USER, accessToken.getLoginAccount(), UserDetail.class);
        caffeineCache.put(CacheName.USER, accessToken.getLoginAccount(), userDetail);
        return ApiResult.ok(accessToken);
    }
}
