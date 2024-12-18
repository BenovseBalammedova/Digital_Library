package com.digital_libary.Digital_Library.sale.controller;

import com.digital_libary.Digital_Library.sale.dto.SaleRequest;
import com.digital_libary.Digital_Library.sale.entity.Sale;
import com.digital_libary.Digital_Library.sale.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sale/")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping()
    public void create(@RequestBody SaleRequest sale) {
        saleService.create(sale);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody SaleRequest sale) {
        saleService.update(id, sale);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        saleService.delete(id);
    }

    @GetMapping("{id}")
    public Sale getById(@PathVariable Long id) {
        return saleService.getById(id);
    }

    @GetMapping()
    public List<Sale> getAllSale() {
        return saleService.getAllSale();
    }

    @GetMapping("{book-id}")
    public List<Sale> getSalesByBookId(@PathVariable String bookId) {
        return saleService.getSalesByBookId(bookId);
    }

    @GetMapping("{user-id}")
    public List<Sale> getSalesByUserId(@PathVariable String userId) {
        return saleService.getSalesByUserId(userId);
    }

    @GetMapping("salesman/{salesman-id}")
    public List<Sale> getSalesBySalesmanId(@PathVariable String salesmanId) {
        return saleService.getSalesBySalesmanId(salesmanId);
    }

    @GetMapping("{payment-id}")
    public List<Sale> getSalesByPaymentId(@PathVariable String paymentId) {
        return saleService.getSalesByPaymentId(paymentId);
    }

    @GetMapping("total-sales/{user-id}")
    public Double getTotalSalesByUserId(@PathVariable String userId) {
        return saleService.getTotalSalesByUserId(userId);
    }

    @GetMapping("{salesman-id}")
    public Double getTotalSalesBySalesmanId(@PathVariable String salesmanId) {
        return saleService.getTotalSalesBySalesmanId(salesmanId);
    }

    @GetMapping("total-amount")
    public  Sale getByTotalAmount() {
        return saleService.getByTotalAmount();
    }

    @GetMapping("discounts")
    public List<Sale> getSalesWithDiscountApplied() {
        return saleService.getSalesWithDiscountApplied();
    }

    @GetMapping("between-dates/{start-date}/{end-date}")
    public List<Sale> getSalesBetweenDates(
            @PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
        return saleService.getSalesBetweenDates(startDate, endDate);
    }

    @GetMapping("between-discount/{min-discount}/{max-discount}")
    public List<Sale> getSalesByDiscountBetween(
            @PathVariable Double minDiscount, @PathVariable Double maxDiscount) {
        return saleService.getSalesByDiscountBetween(minDiscount, maxDiscount);
    }

    @GetMapping("between-price/{min-price}/{max-price}")
    public List<Sale> getSalesByPriceBetween(
            @PathVariable Double minPrice, @PathVariable Double maxPrice) {
        return saleService.getSalesByPriceBetween(minPrice, maxPrice);
    }
}
