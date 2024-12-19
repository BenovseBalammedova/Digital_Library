package com.digital_libary.Digital_Library.security;

import com.digital_libary.Digital_Library.user.entity.User;
import com.digital_libary.Digital_Library.user.exception.subexception.UserNotFoundException;
import com.digital_libary.Digital_Library.user.mapper.UserMapper;
import com.digital_libary.Digital_Library.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (repository.findUserByEmail(username))
                .orElseThrow(() -> new UserNotFoundException(username));
        return mapper.toMyUserDetails(user);
    }
}
