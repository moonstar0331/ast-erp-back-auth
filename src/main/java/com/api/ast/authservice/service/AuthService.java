package com.api.ast.authservice.service;

import com.api.ast.authservice.dto.TokenDto;
import com.api.ast.authservice.entity.LoginHistory;

public interface AuthService {
    TokenDto authorize(String loginId, String password);
    TokenDto reissue(String accessToken, String refreshToken);
    void logout(String accessToken, String refreshToken);
    boolean validateCheck(String loginId, String userUuid);
    void recordLoginHistory(LoginHistory loginHistory);
}

