package com.digital_libary.Digital_Library.punishment.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PunishmentResponse {

    Long userId;

    Long bookId;

    Double price;

    LocalDate startDate;

    LocalDate endDate;

    String reason;

    String status;

    Double fineAmount;

}
