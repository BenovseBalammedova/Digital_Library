package com.digital_libary.Digital_Library.user.mapper;

import com.digital_libary.Digital_Library.user.dto.UserRequest;
import com.digital_libary.Digital_Library.user.dto.UserResponse;
import com.digital_libary.Digital_Library.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "Spring")
public interface UserMapper {

    UserResponse toDto(User userResponse);

    User toEntity(UserRequest userRequest);

    void updateUserFromDto(UserRequest updateUser, @MappingTarget User user);
}
