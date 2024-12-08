package com.digital_libary.Digital_Library.punishment.controller;

import com.digital_libary.Digital_Library.punishment.dto.PunishmentRequest;
import com.digital_libary.Digital_Library.punishment.entity.Punishment;
import com.digital_libary.Digital_Library.punishment.service.PunishmentAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/punishment")
@RequiredArgsConstructor
public class PunishmentAdminController {
    private final PunishmentAdminService punishmentAdminService;

    @PostMapping()
    public void addPunishment(@RequestBody PunishmentRequest punishment) {
        punishmentAdminService.addPunishment(punishment);
    }

    @GetMapping("/get_all")
    public List<Punishment> getAllPunishments() {
        return punishmentAdminService.getAllPunishments();
    }

    @GetMapping("/{userId}/{bookId}")
    public List<Punishment> getPunishmentsByUserAndBook(String userId, String bookId) {
        return punishmentAdminService.getPunishmentsByUserAndBook(userId, bookId);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody PunishmentRequest punishment) {
        punishmentAdminService.update(id, punishment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        punishmentAdminService.delete(id);
    }

    @GetMapping("/applyOverduePunishments")
    public void applyPunishmentIfOverdue() {
        punishmentAdminService.applyPunishmentIfOverdue();

    }

}
