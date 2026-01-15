package com.api.ast.authservice.service.impl;

import com.api.ast.authservice.dto.department.DepartmentDto;
import com.api.ast.authservice.exception.AuthServiceException;
import com.api.ast.authservice.exception.ErrorCode;
import com.api.ast.authservice.mapper.DepartmentMapper;
import com.api.ast.authservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentMapper departmentMapper;

    @Override
    @Transactional
    public void insertOne(DepartmentDto dto) {
        try {
            departmentMapper.insertOne(dto);
        } catch (Exception e) {
            throw new AuthServiceException(ErrorCode.DEPARTMENT_CREATE_ERROR);
        }
    }

    @Override
    public DepartmentDto selectOne(Long deptId) {
        return departmentMapper.selectOne(deptId);
    }

    @Override
    public List<DepartmentDto> selectAll() {
        return departmentMapper.selectAll();
    }

    @Override
    @Transactional
    public DepartmentDto updateOne(DepartmentDto dto) {
        int result = departmentMapper.updateOne(dto);

        if (result == 0) {
            throw new AuthServiceException(ErrorCode.DEPARTMENT_UPDATE_ERROR);
        }

        return selectOne(dto.getDeptId());
    }

    @Override
    @Transactional
    public List<DepartmentDto> updateMany(List<DepartmentDto> dtoList) {
        int result = departmentMapper.updateMany(dtoList);

        if (result == 0 || result != dtoList.size()) {
            throw new AuthServiceException(ErrorCode.DEPARTMENT_UPDATE_ERROR);
        }

        return dtoList;
    }
}
