package com.api.ast.authservice.vo.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserValidatedResponse {
    private boolean isActivated;
}
