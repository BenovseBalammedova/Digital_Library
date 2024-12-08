package com.digital_libary.Digital_Library.rent.repository;

import com.digital_libary.Digital_Library.rent.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

    List<Rent> findByUserId(String userId);

    @Query("SELECT  u.username FROM  User u WHERE u.id = :userId")
    String findUserNames(@Param("userId") String userId);

    @Query("SELECT  b.name FROM  Book b WHERE b.id = :bookId")
    String findBookNames(@Param("bookId") String bookId);

    @Query("SELECT r FROM Rent r WHERE r.startDate BETWEEN :startDate AND :returnDate")
    List<Rent> findAllByStartDateBetweenAndReturnDateBetween(
            @Param("startDate") LocalDate startDate, @Param("returnDate") LocalDate returnDate);

}






