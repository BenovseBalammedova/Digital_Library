package com.digital_libary.Digital_Library.user.controller;

import com.digital_libary.Digital_Library.user.dto.UserRequest;
import com.digital_libary.Digital_Library.user.entity.User;
import com.digital_libary.Digital_Library.user.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/v2/")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping()
    public List<User> getAll() {
        return adminService.getAll();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable Long id) {
        return adminService.getById(id);
    }

    @GetMapping("{address}")
    public List<User> getByAddress(@PathVariable String address) {
        return adminService.getByAddress(address);
    }

    @GetMapping("{age}")
    public List<User> getByAge(@PathVariable Integer age) {
        return adminService.getByAge(age);
    }

    @GetMapping("{phone-number}")
    public List<User> getByPhoneNumber(@PathVariable String phoneNumber) {
        return adminService.getByPhoneNumber(phoneNumber);
    }

    @GetMapping("age-between/{minAge}/{maxAge}")
   public List<User> getByAgeBetween(@PathVariable Integer minAge,@PathVariable Integer maxAge){
        return adminService.getByAgeBetween(minAge, maxAge);
   }

    @PostMapping()
    public void create(@RequestBody UserRequest user) {
        adminService.create(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        adminService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UserRequest user) {
        adminService.update(id, user);
    }


}
