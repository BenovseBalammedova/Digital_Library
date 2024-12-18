package com.digital_libary.Digital_Library.rent.controller;

import com.digital_libary.Digital_Library.rent.dto.RentRequest;
import com.digital_libary.Digital_Library.rent.dto.RentResponse;
import com.digital_libary.Digital_Library.rent.service.RentUserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users/v1/")
@RequiredArgsConstructor
public class RentUserController {
    private final RentUserService service;

    @GetMapping("{user-id}")
    public List<RentResponse> myRentGetAll(@PathVariable String userId) {
        return service.myRentGetAll(userId);
    }

    @PostMapping()
    public void create(@RequestBody RentRequest dto) {
        service.create(dto);
    }

    @DeleteMapping("{user-id}/{book-name}")
    public void deleteRent(@PathVariable String userId, @PathVariable String bookName) {
        service.deleteRent(userId, bookName);

    }

}
