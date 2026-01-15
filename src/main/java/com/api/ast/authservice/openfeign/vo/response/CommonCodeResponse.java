package com.api.ast.authservice.openfeign.vo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonCodeResponse {
    private Long codeId;
    private Long groupCodeId;
    private String groupCode;
    private String codeValue;
    private String codeName;
    private String useYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deletedYn;
}
