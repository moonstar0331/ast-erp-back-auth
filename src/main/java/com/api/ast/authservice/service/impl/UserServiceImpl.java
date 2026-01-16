package com.api.ast.authservice.service.impl;

import com.api.ast.authservice.dto.UserDto;
import com.api.ast.authservice.entity.User;
import com.api.ast.authservice.entity.constant.UserRole;
import com.api.ast.authservice.exception.AuthServiceException;
import com.api.ast.authservice.exception.ErrorCode;
import com.api.ast.authservice.mapper.UserMapper;
import com.api.ast.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void join(UserDto userDto) {
        if(userMapper.existsByEmail(userDto.getEmail())) {
            throw new AuthServiceException(ErrorCode.DUPLICATED_USER_EMAIL);
        }

        User user = User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .phone(userDto.getPhone())
                .userUuid(UUID.randomUUID().toString())
                .role(UserRole.USER)
                .deletedYn(false)
                .build();

        try {
            userMapper.insert(user);
        } catch (Exception e) {
            throw new AuthServiceException(ErrorCode.USER_CREATION_ERROR);
        }
    }

    @Override
    public UserDto getUserByUserUuid(String userUuid) {
        User user = userMapper.findByUserUuid(userUuid).orElseThrow(() ->
            new AuthServiceException(ErrorCode.USER_NOT_FOUND));

        return new ModelMapper().map(user, UserDto.class);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userMapper.findByEmail(email).orElseThrow(() ->
                new AuthServiceException(ErrorCode.USER_NOT_FOUND));

        return new ModelMapper().map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> userList = userMapper.findAll();

        ModelMapper mapper = new ModelMapper();

        List<UserDto> userDtoList = new ArrayList<>();
        userList.forEach(u -> {
            userDtoList.add(mapper.map(u, UserDto.class));
        });

        return userDtoList;
    }

    @Override
    @Transactional
    public void modifyUserinfo(String email, String userUuid, String nickname, String password) {
        User user = userMapper.findByEmail(email).orElseThrow(() ->
                new AuthServiceException(ErrorCode.USER_NOT_FOUND));

        if(!user.getUserUuid().equals(userUuid)) {
            throw new AuthServiceException(ErrorCode.INVALID_USER_UUID);
        }

        user.modifyUserInfo(passwordEncoder.encode(password));

        userMapper.update(user);
    }

    @Override
    @Transactional
    public void deleteUser(String email, String userUuid) {
        User user = userMapper.findByEmail(email).orElseThrow(() ->
                new AuthServiceException(ErrorCode.USER_NOT_FOUND));

        if(!user.getUserUuid().equals(userUuid)) {
            throw new AuthServiceException(ErrorCode.INVALID_USER_UUID);
        }

        try {
            user.changeDeleted(true);
            userMapper.update(user);
        } catch (Exception e) {
            throw new AuthServiceException(ErrorCode.USER_DELETE_ERROR);
        }

    }

    @Override
    @Transactional
    public User userUpdate(User user) {
        int result = userMapper.update(user);
        if (result == 0)
            return null;
        return user;
    }
}
