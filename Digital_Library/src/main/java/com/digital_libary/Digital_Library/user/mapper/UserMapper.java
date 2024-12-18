package com.digital_libary.Digital_Library.user.mapper;

import com.digital_libary.Digital_Library.security.MyUserSecurity;
import com.digital_libary.Digital_Library.user.dto.RegisterRequest;
import com.digital_libary.Digital_Library.user.dto.UserRequest;
import com.digital_libary.Digital_Library.user.dto.UserResponse;
import com.digital_libary.Digital_Library.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "Spring")
public interface UserMapper {

    UserResponse toDto(User userResponse);

    User toEntity(UserRequest userRequest);

    MyUserSecurity toMyUserSecurity(User user);

    User toUserFromRegisterRequest(RegisterRequest request);

    void updateUserFromDto(UserRequest updateUser, @MappingTarget User user);
}
