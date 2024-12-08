package com.digital_libary.Digital_Library.rent.service.impl;

import com.digital_libary.Digital_Library.rent.entity.Rent;
import com.digital_libary.Digital_Library.rent.exception.subexception.RentInvalidException;
import com.digital_libary.Digital_Library.rent.exception.subexception.RentNotFoundException;
import com.digital_libary.Digital_Library.rent.repository.RentRepository;
import com.digital_libary.Digital_Library.rent.service.RentAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentAdminServiceImpl implements RentAdminService {
    private final RentRepository repository;

    @Override
    public void deleteRent(Long id) {
        if (id <= 0) {
            throw new RentInvalidException("Id is not correct");
        }
        repository.deleteById(id);
    }

    @Override
    public Rent getRentById(Long id) {
        return repository.findById(id).orElseThrow(()->new RentNotFoundException("Rent is not found"));
    }

    @Override
    public List<Rent> getAllRents() {
        return repository.findAll();
    }

    @Override
    public List<Rent> getRentsByDateRange(LocalDate startDate, LocalDate returnDate) {
        return repository.findAllByStartDateBetweenAndReturnDateBetween(startDate, returnDate);
    }

}
