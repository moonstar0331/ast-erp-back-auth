package com.api.ast.authservice.mapper;

import com.api.ast.authservice.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    Optional<User> findByUserUuid(@Param("userUuid") String userUuid);

    Optional<User> findByLoginId(@Param("loginId") String loginId);

    Optional<User> findByEmail(@Param("email") String email);

    Optional<User> findById(@Param("userId") Long userId);

    List<User> findAll();

    int insert(@Param("user") User user);

    int update(@Param("user") User user);

    int deleteById(@Param("userId") Long userId);

    boolean existsByEmail(@Param("email") String email);

    boolean existsByLoginId(@Param("loginId") String loginId);
}

    