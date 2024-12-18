package com.digital_libary.Digital_Library.user.controller;

import com.digital_libary.Digital_Library.user.dto.RegisterRequest;
import com.digital_libary.Digital_Library.user.dto.UserRequest;
import com.digital_libary.Digital_Library.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/v2/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public void create(UserRequest user) {
        userService.create(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping("{id}")
    public void updateById(@PathVariable Long id, @RequestBody UserRequest user) {
        userService.updateById(id, user);
    }

    @PostMapping("register")
    public void register(@RequestBody @Valid RegisterRequest request){
        userService.register(request);
    }
}
