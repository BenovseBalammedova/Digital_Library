package com.digital_libary.Digital_Library.punishment.controller;

import com.digital_libary.Digital_Library.punishment.dto.PunishmentRequest;
import com.digital_libary.Digital_Library.punishment.entity.Punishment;
import com.digital_libary.Digital_Library.punishment.service.PunishmentAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/punishment/")
@RequiredArgsConstructor
public class PunishmentAdminController {
    private final PunishmentAdminService service;

    @PostMapping()
    public void addPunishment(@RequestBody PunishmentRequest punishment) {
        service.addPunishment(punishment);
    }

    @GetMapping()
    public List<Punishment> getAllPunishments() {
        return service.getAllPunishments();
    }

    @GetMapping("{user-id}/{book-id}")
    public List<Punishment> getPunishmentsByUserAndBook(@PathVariable String userId,@PathVariable String bookId)
    {
        return service.getPunishmentsByUserAndBook(userId, bookId);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody PunishmentRequest punishment) {
        service.update(id, punishment);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
