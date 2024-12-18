package com.digital_libary.Digital_Library.punishment.service.impl;

import com.digital_libary.Digital_Library.punishment.entity.Punishment;
import com.digital_libary.Digital_Library.punishment.exception.subexception.PunishmentInvalidException;
import com.digital_libary.Digital_Library.punishment.exception.subexception.PunishmentNotFoundException;
import com.digital_libary.Digital_Library.punishment.repository.PunishmentRepository;
import com.digital_libary.Digital_Library.punishment.service.PunishmentUserService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class PunishmentUserServiceImpl implements PunishmentUserService {
    private final PunishmentRepository repository;

    @Override
    public Punishment getPunishmentById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new PunishmentNotFoundException("Admin is not found"));
    }

    @Override
    public Punishment getPunishmentDetails(Long id, String userId) {
        if (id <= 0) {
            throw new PunishmentInvalidException("Id is not correct");
        }
        return repository.findByIdAndUserId(id, userId);
    }

    @Override
    public void processReturnAndFine(Long id) {
        Punishment punishment = repository.findById(id).orElseThrow(() ->
                new PunishmentNotFoundException("Punishment is not found"));
        LocalDate today = LocalDate.now();
        if (today.isAfter(punishment.getStartDate())) {
            long daysOverdue = ChronoUnit.DAYS.between(punishment.getStartDate(), today);
            double fine = daysOverdue * 2;
            punishment.setFineAmount(fine);
        } else {
            punishment.setFineAmount(0.0);
        }
        punishment.setStartDate(today);
        repository.save(punishment);
    }
}
