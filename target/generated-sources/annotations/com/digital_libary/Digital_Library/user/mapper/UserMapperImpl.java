package com.digital_libary.Digital_Library.user.mapper;

import com.digital_libary.Digital_Library.user.dto.UserRequest;
import com.digital_libary.Digital_Library.user.dto.UserResponse;
import com.digital_libary.Digital_Library.user.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-01T11:23:50-0800",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse toDto(User userResponse) {
        if ( userResponse == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse1 = UserResponse.builder();

        userResponse1.id( userResponse.getId() );
        userResponse1.username( userResponse.getUsername() );
        userResponse1.age( userResponse.getAge() );
        userResponse1.email( userResponse.getEmail() );
        userResponse1.phoneNumber( userResponse.getPhoneNumber() );
        userResponse1.address( userResponse.getAddress() );
        userResponse1.role( userResponse.getRole() );

        return userResponse1.build();
    }

    @Override
    public User toEntity(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( userRequest.getUsername() );
        user.age( userRequest.getAge() );
        user.email( userRequest.getEmail() );
        user.password( userRequest.getPassword() );
        user.phoneNumber( userRequest.getPhoneNumber() );
        user.address( userRequest.getAddress() );
        user.role( userRequest.getRole() );

        return user.build();
    }

    @Override
    public void updateUserFromDto(UserRequest updateUser, User user) {
        if ( updateUser == null ) {
            return;
        }

        user.setUsername( updateUser.getUsername() );
        user.setAge( updateUser.getAge() );
        user.setEmail( updateUser.getEmail() );
        user.setPassword( updateUser.getPassword() );
        user.setPhoneNumber( updateUser.getPhoneNumber() );
        user.setAddress( updateUser.getAddress() );
        user.setRole( updateUser.getRole() );
    }
}
