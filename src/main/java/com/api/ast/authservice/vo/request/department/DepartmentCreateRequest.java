package com.api.ast.authservice.vo.request.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentCreateRequest {
    private Long parentDeptId;
    private String deptName;
    private String deptTypeCode;
    private String useYn;
}
