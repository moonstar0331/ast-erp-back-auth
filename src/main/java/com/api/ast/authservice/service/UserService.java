package com.api.ast.authservice.service;

import com.api.ast.authservice.dto.UserDto;
import com.api.ast.authservice.entity.User;

import java.util.List;

public interface UserService {

    void join(UserDto userDto);

    UserDto getUserByUserUuid(String userUuid);

    UserDto getUserByLoginId(String loginId);

    UserDto getUserByEmail(String email);

    List<UserDto> getUsers();

    void modifyUserinfo(String loginId, String userUuid, String nickname, String password);

    void deleteUser(String loginId, String userUuid);

    User userUpdate(User user);
}
