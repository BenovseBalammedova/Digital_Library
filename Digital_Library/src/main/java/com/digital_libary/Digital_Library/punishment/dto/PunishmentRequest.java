package com.digital_libary.Digital_Library.punishment.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PunishmentRequest {

    Long userId;

    Long bookId;

    Double price;

}
