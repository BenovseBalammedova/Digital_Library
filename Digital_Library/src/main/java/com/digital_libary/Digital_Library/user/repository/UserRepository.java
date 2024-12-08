package com.digital_libary.Digital_Library.user.repository;

import com.digital_libary.Digital_Library.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByAddressContainingIgnoreCase(String address);

    List<User> findByPhoneNumberContainingIgnoreCase(String phoneNumber);

    List<User> findByAgeBetween(Integer minAge, Integer maxAge);

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.username = :username")
    boolean existsByUsername(@Param("username") String username);

}
