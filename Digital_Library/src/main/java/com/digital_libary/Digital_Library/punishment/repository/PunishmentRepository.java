package com.digital_libary.Digital_Library.punishment.repository;

import com.digital_libary.Digital_Library.punishment.entity.Punishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PunishmentRepository extends JpaRepository<Punishment,Long> {

    List<Punishment> findByUserIdAndBookId(String userId, String bookId);

    Punishment  findByIdAndUserId(Long id, String userId);

}
