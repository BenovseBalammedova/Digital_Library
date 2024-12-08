package com.digital_libary.Digital_Library.rent.service;


import com.digital_libary.Digital_Library.rent.dto.RentRequest;
import com.digital_libary.Digital_Library.rent.dto.RentResponse;

import java.util.List;

public interface RentUserService {

    List<RentResponse> myRentGetAll(String userId);

    void create(RentRequest dto);

    void deleteRent(String userId,String bookName);

}



