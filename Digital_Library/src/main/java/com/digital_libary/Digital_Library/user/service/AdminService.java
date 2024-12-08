package com.digital_libary.Digital_Library.user.service;

import com.digital_libary.Digital_Library.user.dto.UserRequest;
import com.digital_libary.Digital_Library.user.entity.User;

import java.util.List;

public interface AdminService {

    List<User> getAll();

    User getById(Long id);

    List<User> getByAddress(String address);

    List<User> getByAge(Integer age);

    List<User> getByPhoneNumber(String phoneNumber);

    List<User> getByAgeBetween(Integer minAge, Integer maxAge);

    void create(UserRequest user);

    void isUsernameTaken(String username);

    void validatePassword(String password);

    void delete(Long id);

    void update(Long id, UserRequest user);

}
