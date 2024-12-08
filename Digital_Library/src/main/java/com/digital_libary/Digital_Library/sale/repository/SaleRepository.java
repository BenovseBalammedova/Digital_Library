package com.digital_libary.Digital_Library.sale.repository;

import com.digital_libary.Digital_Library.sale.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findByFkBookId(String bookId);

    List<Sale> findByFkUserId(String userId);

    List<Sale> findByFkPaymentId(String paymentId);

    List<Sale> findByFkSalesmanId(String salesmanId);

    List<Sale> findBySalePriceBetween(Double minPrice, Double maxPrice);

    List<Sale> findBySaleDateBetween(LocalDate startDate, LocalDate endDate);

    List<Sale> findByDiscountBetween(Double minDiscount, Double maxDiscount);

    @Query("SELECT s FROM Sale s WHERE s.discount > 0")
    List<Sale> findBySalesWithDiscountApplied();

    @Query("SELECT SUM(s.totalAmount) FROM Sale s WHERE s.fkUserId=:userId")
    Double findByTotalSalesByUserId(@Param("userId") String userId);

    @Query("SELECT SUM(s.totalAmount) FROM Sale s WHERE s.fkSalesmanId=:salesmanId")
    Double findByTotalSalesBySalesmanId(@Param("salesmanId") String salesmanId);

    Sale findTopByOrderByTotalAmountDesc();

}
