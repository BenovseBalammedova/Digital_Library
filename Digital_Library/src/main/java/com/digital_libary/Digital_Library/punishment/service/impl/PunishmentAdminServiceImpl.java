package com.digital_libary.Digital_Library.punishment.service.impl;

import com.digital_libary.Digital_Library.punishment.dto.PunishmentRequest;
import com.digital_libary.Digital_Library.punishment.entity.Punishment;

import com.digital_libary.Digital_Library.punishment.exception.subexception.PunishmentNotFoundException;
import com.digital_libary.Digital_Library.punishment.mapper.PunishmentMapper;
import com.digital_libary.Digital_Library.punishment.repository.PunishmentRepository;
import com.digital_libary.Digital_Library.punishment.service.PunishmentAdminService;
import com.digital_libary.Digital_Library.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PunishmentAdminServiceImpl implements PunishmentAdminService {
    private final PunishmentRepository repository;
    private final PunishmentMapper mapper;
    private final ReportService reportService;

    @Override
    public void addPunishment(PunishmentRequest punishment) {
       Punishment punishments=mapper.toEntity(punishment);
       repository.save(punishments);
        reportService.addFineAmount(punishment.getFineAmount());


    }

    @Override
    public List<Punishment> getAllPunishments() {
        return repository.findAll();
    }

    @Override
    public List<Punishment> getPunishmentsByUserAndBook(String userId, String bookId) {
     List<Punishment> punishments= repository.findByUserIdAndBookId(userId, bookId);
        if (punishments.isEmpty()) {
            throw new PunishmentNotFoundException("Punishment not found for userId: " + userId + " and bookId: " + bookId);
        }
        return  punishments ;
    }

    @Override
    public void update(Long id, PunishmentRequest punishment) {
   Punishment punishments=repository.findById(id).orElseThrow();
   mapper.updatePunishmentFromDto(punishment,punishments);
   repository.save(punishments);

    }

    @Override
    public void delete(Long id) {
       repository.deleteById(id);
    }

    @Override
    public void applyPunishmentIfOverdue() {
        LocalDate today=LocalDate.now();
        List<Punishment> allPunishments = repository.findAll();
        for (Punishment punishment:allPunishments){
            if (punishment.getEndDate().isBefore(today)&&"Unpaid".equals(punishment.getStatus())){
                punishment.setStatus("Applied");
                punishment.setPrice(punishment.getPrice() + 10.0);
                repository.save(punishment);
            }
        }
    }


}
