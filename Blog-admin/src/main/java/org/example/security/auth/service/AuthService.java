package org.example.security.auth.service;

import org.example.common.bo.ApiResult;

public interface AuthService {

    ApiResult login(String loginAccount, String password);

    ApiResult logout();

    ApiResult refreshToken(String token);
}
