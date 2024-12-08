package com.digital_libary.Digital_Library.sale.service.impl;

import com.digital_libary.Digital_Library.report.service.ReportService;
import com.digital_libary.Digital_Library.sale.dto.SaleRequest;
import com.digital_libary.Digital_Library.sale.entity.Sale;
import com.digital_libary.Digital_Library.sale.exception.subexception.SaleInvalidException;
import com.digital_libary.Digital_Library.sale.exception.subexception.SaleNotFoundException;
import com.digital_libary.Digital_Library.sale.mapper.SaleMapper;
import com.digital_libary.Digital_Library.sale.repository.SaleRepository;
import com.digital_libary.Digital_Library.sale.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository repository;
    private final SaleMapper mapper;
    private final ReportService reportService;

    @Override
    public void create(SaleRequest sale) {
        try {
            Sale sales = mapper.toEntity(sale);
              repository.save(sales);

            reportService.addTotalDiscount(sale.getDiscount());

            if (sale.getCount() != null) {
                reportService.addToTotalSalesBook(sale.getCount());
            }
            reportService.incrementSaleCount();
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("You are entering something illegal.");
        }
    }

    @Override
    public void update(Long id, SaleRequest sale) {
        if (id <= 0) {
            throw new SaleInvalidException("Id is not correct");
        }
        Sale sales = repository.findById(id).orElseThrow(() -> new SaleNotFoundException("Sale is not found"));
        mapper.updateSaleFromDto(sale, sales);
        repository.save(sales);
    }

    @Override
    public void delete(Long id) {
        if (id <= 0) {
            throw new SaleInvalidException("Id is not correct");
        }
        repository.deleteById((id));
    }

    @Override
    public Sale getById(Long id) {
        if (id <= 0) {
            throw new SaleInvalidException("Id is not correct");
        }
        return repository.findById(id).orElseThrow(() -> new SaleNotFoundException("Sale is not found"));
    }

    @Override
    public Double getTotalSalesByUserId(String userId) {
        return repository.findByTotalSalesByUserId(userId);
    }

    @Override
    public Double getTotalSalesBySalesmanId(String salesmanId) {
        return repository.findByTotalSalesBySalesmanId(salesmanId);
    }

    @Override
    public Sale getByTotalAmount() {
        return repository.findTopByOrderByTotalAmountDesc();
    }

    @Override
    public List<Sale> getSalesWithDiscountApplied() {
        return repository.findBySalesWithDiscountApplied();
    }

    @Override
    public List<Sale> getSalesBetweenDates(LocalDate startDate, LocalDate endDate) {
        return repository.findBySaleDateBetween(startDate, endDate);
    }

    @Override
    public List<Sale> getSalesByDiscountBetween(Double minDiscount, Double maxDiscount) {
        return repository.findByDiscountBetween(minDiscount, maxDiscount);
    }

    @Override
    public List<Sale> getSalesByPriceBetween(Double minPrice, Double maxPrice) {
        return repository.findBySalePriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Sale> getAllSale() {
        return repository.findAll();
    }

    @Override
    public List<Sale> getSalesByBookId(String bookId) {
        if (bookId == null || bookId.trim().isEmpty()) {
            throw new SaleInvalidException("Book ID cannot be null or empty");
        }
        return repository.findByFkBookId(bookId);
    }

    @Override
    public List<Sale> getSalesByUserId(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new SaleInvalidException("User ID cannot be null or empty");
        }
        return repository.findByFkUserId(userId);
    }

    @Override
    public List<Sale> getSalesBySalesmanId(String salesmanId) {
        if (salesmanId == null || salesmanId.trim().isEmpty()) {
            throw new SaleInvalidException("Salesman ID cannot be null or empty");
        }
        return repository.findByFkSalesmanId(salesmanId);
    }

    @Override
    public List<Sale> getSalesByPaymentId(String paymentId) {
        if (paymentId == null || paymentId.trim().isEmpty()) {
            throw new SaleInvalidException("Payment ID cannot be null or empty");
        }
        return repository.findByFkPaymentId(paymentId);
    }
}
