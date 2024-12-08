package com.digital_libary.Digital_Library.sale.service;

import com.digital_libary.Digital_Library.sale.dto.SaleRequest;
import com.digital_libary.Digital_Library.sale.entity.Sale;

import java.time.LocalDate;
import java.util.List;

public interface SaleService {

    void delete(Long id);

    Sale getById(Long id);

    void create(SaleRequest sale);

    void update(Long id, SaleRequest sale);

    Sale getByTotalAmount();

    List<Sale> getAllSale();

    List<Sale> getSalesByBookId(String bookId);

    List<Sale> getSalesByUserId(String userId);

    List<Sale> getSalesByPaymentId(String paymentId);

    List<Sale> getSalesBySalesmanId(String salesmanId);

    Double getTotalSalesByUserId(String userId);

    Double getTotalSalesBySalesmanId(String salesmanId);

    List<Sale> getSalesWithDiscountApplied();

    List<Sale> getSalesBetweenDates(LocalDate startDate, LocalDate endDate);

    List<Sale> getSalesByDiscountBetween(Double minDiscount, Double maxDiscount);

    List<Sale> getSalesByPriceBetween(Double minPrice, Double maxPrice);


}
