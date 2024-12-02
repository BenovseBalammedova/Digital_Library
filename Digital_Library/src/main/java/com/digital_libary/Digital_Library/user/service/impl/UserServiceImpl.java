package com.digital_libary.Digital_Library.user.service.impl;

import com.digital_libary.Digital_Library.user.dto.UserRequest;
import com.digital_libary.Digital_Library.user.entity.User;
import com.digital_libary.Digital_Library.user.exception.subexception.UserInvalidException;
import com.digital_libary.Digital_Library.user.exception.subexception.UserNotFoundException;
import com.digital_libary.Digital_Library.user.mapper.UserMapper;
import com.digital_libary.Digital_Library.user.repository.UserRepository;
import com.digital_libary.Digital_Library.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;
    private final UserRepository userRepository;

    @Override
    public void create(UserRequest user) {
        User users = mapper.toEntity(user);
        userRepository.save(users);

    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, UserRequest user) {
        if (id <= 0) {
            throw new UserInvalidException("Id is not correct");

        }
        User users = userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User is not found"));
        mapper.updateUserFromDto(user, users);
        userRepository.save(users);

    }
}
