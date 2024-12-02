package com.digital_libary.Digital_Library.sale.service;

import com.digital_libary.Digital_Library.sale.dto.SaleRequest;
import com.digital_libary.Digital_Library.sale.entity.Sale;

import java.util.List;

public interface SaleService {

    void create(SaleRequest sale);

    void update(Long id, SaleRequest sale);

    void delete(Long id);

    Sale getById(Long id);


    List<Sale> getAllSale();

    List<Sale> getSalesByBookId(String bookId);

    List<Sale> getSalesByUserId(String userId);

    List<Sale> getSalesBySalesmanId(String salesmanId);

    List<Sale> getSalesByPaymentId(String paymentId);


}
