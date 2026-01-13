package com.api.ast.authservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.api.ast.authservice.dto.GitHubProfile;
import com.api.ast.authservice.entity.constant.UserRole;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_deleted=false and activated=true")
public class User extends AuditingFields {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "email", length = 50, unique = true)
    private String email;

    @JsonIgnore
    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "dept_id")
    private String deptId;

    @Column(name = "name")
    private String name;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "user_uuid")
    private String userUuid;

    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "status_code")
    private String statusCode;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "joined_date")
    private String joinedDate;

    @Column(name = "deleted_yn", columnDefinition = "boolean default false NOT NULL")
    private boolean deletedYn;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
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
