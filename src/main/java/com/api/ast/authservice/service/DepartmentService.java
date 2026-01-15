package com.api.ast.authservice.service;

import com.api.ast.authservice.dto.department.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    void insertOne(DepartmentDto dto);

    DepartmentDto selectOne(Long deptId);

    List<DepartmentDto> selectAll();

    DepartmentDto updateOne(DepartmentDto dto);

    List<DepartmentDto> updateMany(List<DepartmentDto> dtoList);
}
