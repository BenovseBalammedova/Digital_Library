package com.digital_libary.Digital_Library.punishment.service;

import com.digital_libary.Digital_Library.punishment.entity.Punishment;



public interface PunishmentUserService {

    Punishment getPunishmentById(Long id);

    Punishment getPunishmentDetails(Long id, String userId);

    void processReturnAndFine(Long id);

}
