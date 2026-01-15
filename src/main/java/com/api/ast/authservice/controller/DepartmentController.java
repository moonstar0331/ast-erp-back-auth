package com.api.ast.authservice.controller;

import com.api.ast.authservice.dto.department.DepartmentDto;
import com.api.ast.authservice.service.DepartmentService;
import com.api.ast.authservice.vo.request.department.DepartmentCreateRequest;
import com.api.ast.authservice.vo.request.department.DepartmentUpdateRequest;
import com.api.ast.authservice.vo.response.department.DepartmentResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dept")
public class DepartmentController {

    private final DepartmentService departmentService;

    // 부서 단건 생성
    @PostMapping("/")
    public ResponseEntity<Void> insertOne(@RequestBody DepartmentCreateRequest request) {
        DepartmentDto dto = new ModelMapper().map(request, DepartmentDto.class);
        departmentService.insertOne(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // 부서 다건 생성
    @PostMapping("/list")
    public ResponseEntity<Void> insertMany(@RequestBody List<DepartmentCreateRequest> request) {
        request.forEach(r -> {
            DepartmentDto dto = new ModelMapper().map(r, DepartmentDto.class);
            departmentService.insertOne(dto);
        });

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // 부서 상세 조회
    @GetMapping("/{deptId}")
    public ResponseEntity<DepartmentResponse> selectOne(@PathVariable Long deptId) {
        DepartmentDto dto = departmentService.selectOne(deptId);
        DepartmentResponse response = new ModelMapper().map(dto, DepartmentResponse.class);

        return ResponseEntity.ok(response);
    }

    // 부서 전체 조회
    @GetMapping("/list")
    public ResponseEntity<List<DepartmentResponse>> selectAll() {
        List<DepartmentDto> result = departmentService.selectAll();

        ModelMapper mapper = new ModelMapper();
        List<DepartmentResponse> response = new ArrayList<>();

        result.forEach(dto -> {
            response.add(mapper.map(dto, DepartmentResponse.class));
        });

        return ResponseEntity.ok(response);
    }

    // 부서 단건 수정
    @PutMapping("/{deptId}")
    public ResponseEntity<DepartmentResponse> updateOne(@PathVariable Long deptId, @RequestBody DepartmentCreateRequest request) {
        DepartmentDto dto = new ModelMapper().map(request, DepartmentDto.class);
        dto.setDeptId(deptId);

        DepartmentDto result = departmentService.updateOne(dto);
        DepartmentResponse response = new ModelMapper().map(result, DepartmentResponse.class);

        return ResponseEntity.ok(response);
    }

    // 부서 다건 수정
    @PutMapping("/list")
    public ResponseEntity<List<DepartmentResponse>> updateMany(@RequestBody List<DepartmentUpdateRequest> requests) {
        List<DepartmentDto> dtoList = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();

        requests.forEach(request ->
                dtoList.add(mapper.map(request, DepartmentDto.class))
        );

        List<DepartmentDto> result = departmentService.updateMany(dtoList);
        List<DepartmentResponse> response = new ArrayList<>();

        result.forEach(dto ->
                response.add(mapper.map(dto, DepartmentResponse.class))
        );

        return ResponseEntity.ok(response);
    }

    // 부서 단건 삭제
    @DeleteMapping("/{deptId}")

    // 부서 다건 삭제
    @DeleteMapping("/list")
}
