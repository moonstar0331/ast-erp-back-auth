package com.api.ast.authservice.vo.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long userId;
    private String loginId;
    private String email;
    private String name;
    private String phone;
    private String userUuid;
    private Long deptId;
    private String deptName;
}
