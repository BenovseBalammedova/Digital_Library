package com.digital_libary.Digital_Library.punishment.service;

import com.digital_libary.Digital_Library.punishment.dto.PunishmentRequest;
import com.digital_libary.Digital_Library.punishment.entity.Punishment;

import java.util.List;

public interface PunishmentAdminService {

    void addPunishment(PunishmentRequest punishment);

    List<Punishment> getAllPunishments();

    List<Punishment> getPunishmentsByUserAndBook(String userId, String bookId);

    void update (Long id, PunishmentRequest punishment);

    void delete(Long id);

    void applyPunishmentIfOverdue();

}
