package com.digital_libary.Digital_Library.report.controller;

import com.digital_libary.Digital_Library.report.entity.Report;
import com.digital_libary.Digital_Library.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping("get-all")
    public Report getOrCreateReport(){
      return reportService.getOrCreateReport();
    }

}
