package com.api.ast.authservice.service;

import com.api.ast.authservice.dto.UserDto;
import com.api.ast.authservice.entity.User;

import java.util.List;

public interface UserService {

    void join(UserDto userDto);

    UserDto getUserByUserUuid(String userUuid);

    UserDto getUserByEmail(String email);

    List<UserDto> getUsers();

    void modifyUserinfo(String email, String userUuid, String nickname, String password);

    void deleteUser(String email, String userUuid);

    User userUpdate(User user);
}
