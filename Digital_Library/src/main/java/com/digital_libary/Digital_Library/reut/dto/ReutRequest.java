package com.digital_libary.Digital_Library.reut.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReutRequest {

    Long bookId;

    Long userId;

    LocalDate date;

    LocalDate defaultDate;

}
