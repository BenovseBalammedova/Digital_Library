package com.digital_libary.Digital_Library.rent.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RentResponse {

    String bookName;

    String userName;

    LocalDate startDate;

    LocalDate returnDate;

}
