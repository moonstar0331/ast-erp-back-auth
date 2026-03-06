package com.api.ast.authservice.mapper;

import com.api.ast.authservice.entity.LoginHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginHistoryMapper {
    void insertLoginHistory(LoginHistory loginHistory);
}
