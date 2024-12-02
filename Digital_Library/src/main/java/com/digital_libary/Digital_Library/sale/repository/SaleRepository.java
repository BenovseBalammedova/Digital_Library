package com.digital_libary.Digital_Library.sale.repository;

import com.digital_libary.Digital_Library.sale.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {

    List<Sale> findByFkBookId(String bookId);

    List<Sale> findByFkUserId(String userId);

    List<Sale> findByFkSalesmanId(String salesmanId);

    List<Sale> findByFkPaymentId(String paymentId);
}
