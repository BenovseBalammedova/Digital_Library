package com.digital_libary.Digital_Library.report.service.serviceImpl;

import com.digital_libary.Digital_Library.report.entity.Report;
import com.digital_libary.Digital_Library.report.repository.ReportRepository;
import com.digital_libary.Digital_Library.report.service.ReportService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    @Override
    public Report getOrCreateReport() {
        return reportRepository.findById(1L)
                .orElseGet(() -> {
                    Report newReport = new Report();
                    newReport.setId(1L);
                    newReport.setUserCount(0L);
                    newReport.setBookCount(0L);
                    newReport.setSaleCount(0L);
                    newReport.setTotalSalesBook(0L);
                    newReport.setTotalFineAmount(0.0);
                    newReport.setTotalDiscount(0.0);
                    reportRepository.save(newReport);
                    return newReport;
                });
    }

    @Override
    @Transactional
    public void incrementUserCount() {
        Report report = getOrCreateReport();
        report.setUserCount(report.getUserCount() + 1);
        reportRepository.save(report);
    }

    @Override
    @Transactional
    public void incrementBookCount() {
        Report report = getOrCreateReport();
        report.setBookCount(report.getBookCount() + 1);
        reportRepository.save(report);
    }

    @Override
    @Transactional
    public void incrementSaleCount() {
        Report report = getOrCreateReport();
        report.setSaleCount(report.getSaleCount() + 1);
        reportRepository.save(report);

    }

    @Override
    public void addToTotalSalesBook(Long saleBook) {
        Report report = getOrCreateReport();
        report.setTotalSalesBook(report.getTotalSalesBook() + 1);
        reportRepository.save(report);
    }

    @Override
    public void addFineAmount(Double saleFineAmount) {
        Report report = getOrCreateReport();
        Double fineAmount = report.getTotalFineAmount() != null ? report.getTotalFineAmount() : 0.0;
        report.setTotalFineAmount(fineAmount + saleFineAmount);
        reportRepository.save(report);
    }

    @Override
    public void addTotalDiscount(Double saleDiscount) {
        Report report = getOrCreateReport();
        Double discount = report.getTotalDiscount() != null ? report.getTotalDiscount() : 0.0;
        report.setTotalDiscount(discount + saleDiscount);
        reportRepository.save(report);
    }
}
