package com.digital_libary.Digital_Library.user.repository;

import com.digital_libary.Digital_Library.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
