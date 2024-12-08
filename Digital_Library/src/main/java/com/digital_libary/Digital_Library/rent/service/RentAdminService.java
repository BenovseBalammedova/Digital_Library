package com.digital_libary.Digital_Library.rent.service;

import com.digital_libary.Digital_Library.rent.entity.Rent;

import java.time.LocalDate;
import java.util.List;

public interface RentAdminService {

    void deleteRent(Long id);

    Rent getRentById(Long id);

    List<Rent> getAllRents();

    List<Rent> getRentsByDateRange(LocalDate startDate, LocalDate returnDate);

}
