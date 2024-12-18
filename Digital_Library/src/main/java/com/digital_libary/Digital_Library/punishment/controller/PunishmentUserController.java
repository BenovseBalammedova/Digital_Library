package com.digital_libary.Digital_Library.punishment.controller;

import com.digital_libary.Digital_Library.punishment.entity.Punishment;
import com.digital_libary.Digital_Library.punishment.service.PunishmentUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/v4")
@RequiredArgsConstructor
public class PunishmentUserController {
    private final PunishmentUserService service;

    @GetMapping("/{id}")
    public Punishment getPunishmentById(@PathVariable Long id) {
        return service.getPunishmentById(id);
    }

    @GetMapping("/{id}/{user-id}")
    public Punishment getPunishmentDetails(@PathVariable Long id, @PathVariable String userId) {
        return service.getPunishmentDetails(id, userId);
    }

    @GetMapping("/return/{id}")
    public void processReturnAndFine(@PathVariable Long id) {
        service.processReturnAndFine(id);
    }
}
