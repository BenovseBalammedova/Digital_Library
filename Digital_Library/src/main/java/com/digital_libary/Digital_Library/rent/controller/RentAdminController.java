package com.digital_libary.Digital_Library.rent.controller;

import com.digital_libary.Digital_Library.rent.entity.Rent;
import com.digital_libary.Digital_Library.rent.service.RentAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/admin/v1")
@RequiredArgsConstructor
public class RentAdminController {
    private final RentAdminService service;

    @DeleteMapping("/{id}")
    public void deleteRent(@PathVariable Long id) {
        service.deleteRent(id);
    }

    @GetMapping("/{id}")
    public Rent getRentById(@PathVariable Long id) {
        return service.getRentById(id);
    }

    @GetMapping("/get-all")
    public List<Rent> getAllRents() {
        return service.getAllRents();
    }

    @GetMapping("/date")
    public List<Rent> getRentsByDateRange( LocalDate startDate, LocalDate returnDate) {
        return service.getRentsByDateRange(startDate, returnDate);
    }

}
