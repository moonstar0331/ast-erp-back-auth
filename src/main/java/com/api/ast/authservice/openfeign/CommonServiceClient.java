package com.api.ast.authservice.openfeign;

import com.api.ast.authservice.openfeign.vo.response.CommonCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "common-service")
public interface CommonServiceClient {

    @GetMapping("/api/code/{codeId}")
    ResponseEntity<CommonCodeResponse> selectOne(@PathVariable Long codeId);
}
