package com.digital_libary.Digital_Library.sale.controller;

import com.digital_libary.Digital_Library.sale.dto.SaleRequest;
import com.digital_libary.Digital_Library.sale.entity.Sale;
import com.digital_libary.Digital_Library.sale.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping("/create")
    public void create(@RequestBody SaleRequest sale) {
        saleService.create(sale);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody SaleRequest sale) {
        saleService.update(id, sale);

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        saleService.delete(id);

    }

    @GetMapping("/{id}")
    public Sale getById(@PathVariable Long id) {
        return saleService.getById(id);

    }

    @GetMapping("/get-all")
    public List<Sale> getAllSale() {
        return saleService.getAllSale();
    }

    @GetMapping("/book/{bookId}")
    public List<Sale> getSalesByBookId(@PathVariable String bookId) {
        return saleService.getSalesByBookId(bookId);
    }

    @GetMapping("/user/{userId}")
    public List<Sale> getSalesByUserId(@PathVariable String userId) {
        return saleService.getSalesByUserId(userId);
    }

    @GetMapping("/salesman/{salesmanId}")
    public List<Sale> getSalesBySalesmanId(@PathVariable String salesmanId) {
        return saleService.getSalesBySalesmanId(salesmanId);
    }

    @GetMapping("/payment/{paymentId}")
    public List<Sale> getSalesByPaymentId(@PathVariable String paymentId) {
        return saleService.getSalesByPaymentId(paymentId);
    }
}
