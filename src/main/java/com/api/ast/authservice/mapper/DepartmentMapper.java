package com.api.ast.authservice.mapper;

import com.api.ast.authservice.dto.department.DepartmentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    void insertOne(DepartmentDto dto);

    DepartmentDto selectOne(Long deptId);

    List<DepartmentDto> selectAll();

    int updateOne(DepartmentDto dto);

    int updateMany(List<DepartmentDto> dtoList);
}
