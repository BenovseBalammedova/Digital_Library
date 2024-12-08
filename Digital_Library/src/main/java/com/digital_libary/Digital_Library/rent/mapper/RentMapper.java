package com.digital_libary.Digital_Library.rent.mapper;

import com.digital_libary.Digital_Library.rent.dto.RentRequest;
import com.digital_libary.Digital_Library.rent.dto.RentResponse;
import com.digital_libary.Digital_Library.rent.entity.Rent;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "Spring")
public interface RentMapper {

    RentResponse toDto(Rent rentResponse);

    Rent toEntity(RentRequest rentRequest);

    RentResponse toDto( String bookName,String userName,Rent rent);

}