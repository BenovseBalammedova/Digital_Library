package com.digital_libary.Digital_Library.report.service;

import com.digital_libary.Digital_Library.report.entity.Report;

public interface ReportService {

    Report getOrCreateReport();
    void incrementUserCount();
    void incrementBookCount();
    void incrementSaleCount();
    void addToTotalSalesBook(Long saleBook);
    void addFineAmount(Double saleFineAmount);
    void addTotalDiscount(Double saleDiscount);
}
