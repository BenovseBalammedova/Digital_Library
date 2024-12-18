package com.digital_libary.Digital_Library.user.service.impl;

import com.digital_libary.Digital_Library.user.dto.UserRequest;
import com.digital_libary.Digital_Library.user.exception.subexception.UserInvalidException;
import com.digital_libary.Digital_Library.user.exception.subexception.UserNotFoundException;
import com.digital_libary.Digital_Library.user.exception.subexception.UsernameAlreadyTakenException;
import com.digital_libary.Digital_Library.user.mapper.UserMapper;
import com.digital_libary.Digital_Library.user.repository.UserRepository;
import com.digital_libary.Digital_Library.user.service.AdminService;
import com.digital_libary.Digital_Library.user.entity.User;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository adminRepository;
    private final UserMapper adminMapper;

    @Override
    public List<User> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        if (id <= 0) {
            throw new UserInvalidException("Id is not correct");
        }
        return adminRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("Admin is not found"));
    }

    @Override
    public List<User> getByAddress(String address) {
        return adminRepository.findByAddressContainingIgnoreCase(address);

    }

    @Override
    public List<User> getByAge(Integer age) {
        List<User> users = adminRepository.findAll();
        return users.stream().filter(admin -> Objects.equals(admin.getAge(), age)).toList();
    }

    @Override
    public List<User> getByPhoneNumber(String phoneNumber) {
        return adminRepository.findByPhoneNumberContainingIgnoreCase(phoneNumber);
    }

    @Override
    public List<User> getByAgeBetween(Integer minAge, Integer maxAge) {
        return adminRepository.findByAgeBetween(minAge, maxAge);
    }


    @Override
    public void create(UserRequest user) {
        isUsernameTaken(user.getUsername());
        validatePassword(user.getPassword());
        User users = adminMapper.toEntity(user);
        adminRepository.save(users);
    }

    @Override
    public void isUsernameTaken(String username) {
        if (adminRepository.existsByUsername(username)) {
            throw new UsernameAlreadyTakenException
                    ("This username already exists, please choose another username.");
        }

    }

    @Override
    public void validatePassword(String password) {
        if (password.length() != 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long.");

        }

    }

    @Override
    public void delete(Long id) {
        if (id <= 0) {
            throw new UserInvalidException("Id is not correct");
        }
        adminRepository.deleteById(id);

    }

    @Override
    public void update(Long id, UserRequest user) {
        if (id <= 0) {
            throw new UserInvalidException("Id is not correct");
        }
        User users = adminRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("Admin is not found"));
        adminMapper.updateUserFromDto(user, users);
        adminRepository.save(users);

    }


}
