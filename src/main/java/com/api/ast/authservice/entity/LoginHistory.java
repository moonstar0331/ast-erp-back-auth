package com.api.ast.authservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginHistory {

    private Long loginHistoryId;
    private Long userId;
    private LocalDateTime loginAt;
    private LocalDateTime logoutAt;
    private String loginSuccessYn;
    private String loginIp;
    private String userAgent;
    private String loginType; // WEB / API / SSO / MOBILE
    private String failReason;
    private String sessionId;
    private LocalDateTime createdAt;
}
