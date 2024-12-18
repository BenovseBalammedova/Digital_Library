package com.digital_libary.Digital_Library.security;

import com.digital_libary.Digital_Library.user.mapper.UserMapper;
import com.digital_libary.Digital_Library.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserSecurityService implements UserDetailsService {
    private final UserService userService;
    private final UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return mapper.toMyUserSecurity(userService.getUserByEmail(username));
    }
}
