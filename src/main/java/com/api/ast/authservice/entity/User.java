package com.api.ast.authservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.api.ast.authservice.entity.constant.UserRole;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends AuditingFields {

    @JsonIgnore
    private Long userId;

    private String email;

    @JsonIgnore
    private String password;

    private String deptId;

    private String name;

    private String phone;

    private String userUuid;

    private String statusCode;

    private LocalDateTime birthDate;

    private String joinedDate;

    private boolean deletedYn;

    private UserRole role;

    public void modifyUserInfo(String password) {
        if(password != null) {
            this.password = password;
        }
    }

    public void changeDeleted(boolean isDeleted) {
        this.deletedYn = isDeleted;
    }
}
