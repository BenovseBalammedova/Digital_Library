package com.digital_libary.Digital_Library.rent.service.impl;

import com.digital_libary.Digital_Library.rent.dto.RentRequest;
import com.digital_libary.Digital_Library.rent.dto.RentResponse;
import com.digital_libary.Digital_Library.rent.entity.Rent;
import com.digital_libary.Digital_Library.rent.exception.subexception.RentNotFoundException;
import com.digital_libary.Digital_Library.rent.mapper.RentMapper;
import com.digital_libary.Digital_Library.rent.repository.RentRepository;
import com.digital_libary.Digital_Library.rent.service.RentUserService;
import com.digital_libary.Digital_Library.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentUserServiceImpl implements RentUserService {
    private final RentMapper mapper;
    private final RentRepository repository;

    @Override
    public List<RentResponse> myRentGetAll(String userId) {
        List<Rent> rents = repository.findByUserId(userId);
        List<RentResponse> rentList = new ArrayList<>();
        String bookName;
        String userName;
        for (Rent r : rents) {
            bookName = repository.findBookNames(r.getBookId());
            userName = repository.findUserNames(r.getUserId());
            rentList.add(mapper.toDto(bookName, userName, r));
        }
        return rentList;
    }

    @Override
    public void create(RentRequest dto) {
        Rent rent = mapper.toEntity(dto);
        repository.save(rent);
    }


    @Override
    public void deleteRent(String userId, String bookName) {
        List<Rent> rents = repository.findByUserId(userId);
        Rent rent = rents.stream().filter(r -> mapper.toDto(
                bookName, userId, r).getBookName().equals(bookName)).toList().get(0);
        if (rent.getReturnDate().isAfter(LocalDate.now())) {
            repository.deleteById(rent.getId());
        }
    }
}





