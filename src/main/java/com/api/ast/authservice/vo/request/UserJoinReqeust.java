package com.api.ast.authservice.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserJoinReqeust {
    private String email;
    private String name;
    private String phone;
    private String password;
}
