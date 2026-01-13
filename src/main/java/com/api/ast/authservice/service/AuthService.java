package com.api.ast.authservice.service;

import com.api.ast.authservice.dto.TokenDto;

public interface AuthService {

    TokenDto authorize(String email, String password);

    TokenDto reissue(String accessToken, String refreshToken);

    void logout(String accessToken, String refreshToken);

    boolean validateCheck(String email, String userUuid);
}
