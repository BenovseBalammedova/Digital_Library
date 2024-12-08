package com.digital_libary.Digital_Library.report.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReportResponse {

    Long bookCount;

    Long userCount;

    Long saleCount;

    Double totalDiscount;

    Double totalSalesBook;

    Double totalFineAmount;
}
