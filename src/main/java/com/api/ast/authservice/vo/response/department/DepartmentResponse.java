package com.api.ast.authservice.vo.response.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponse {
    private Long deptId;
    private Long parentDeptId;
    private String deptName;
    private String deptTypeCode;
    private String useYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deletedYn;
}
