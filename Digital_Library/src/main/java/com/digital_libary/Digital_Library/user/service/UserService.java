package com.digital_libary.Digital_Library.user.service;

import com.digital_libary.Digital_Library.user.dto.RegisterRequest;
import com.digital_libary.Digital_Library.user.dto.UserRequest;
import com.digital_libary.Digital_Library.user.entity.User;

public interface UserService {

    void create(UserRequest user);

    void delete(Long id);

    void updateById(Long id, UserRequest user);

    void isUsernameTaken(String username);

    void validatePassword(String password);

    User getUserByEmail(String email);

    void register(RegisterRequest request);
}
