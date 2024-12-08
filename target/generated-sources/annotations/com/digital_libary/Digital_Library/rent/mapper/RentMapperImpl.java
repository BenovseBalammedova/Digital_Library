package com.digital_libary.Digital_Library.rent.mapper;

import com.digital_libary.Digital_Library.rent.dto.RentRequest;
import com.digital_libary.Digital_Library.rent.dto.RentResponse;
import com.digital_libary.Digital_Library.rent.entity.Rent;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-07T15:31:56-0800",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class RentMapperImpl implements RentMapper {

    @Override
    public RentResponse toDto(Rent rentResponse) {
        if ( rentResponse == null ) {
            return null;
        }

        RentResponse.RentResponseBuilder rentResponse1 = RentResponse.builder();

        rentResponse1.startDate( rentResponse.getStartDate() );
        rentResponse1.returnDate( rentResponse.getReturnDate() );

        return rentResponse1.build();
    }

    @Override
    public Rent toEntity(RentRequest rentRequest) {
        if ( rentRequest == null ) {
            return null;
        }

        Rent rent = new Rent();

        rent.setBookId( rentRequest.getBookId() );
        rent.setUserId( rentRequest.getUserId() );
        rent.setStartDate( rentRequest.getStartDate() );
        rent.setReturnDate( rentRequest.getReturnDate() );

        return rent;
    }

    @Override
    public RentResponse toDto(String bookName, String userName, Rent rent) {
        if ( bookName == null && userName == null && rent == null ) {
            return null;
        }

        RentResponse.RentResponseBuilder rentResponse = RentResponse.builder();

        if ( rent != null ) {
            rentResponse.startDate( rent.getStartDate() );
            rentResponse.returnDate( rent.getReturnDate() );
        }
        rentResponse.bookName( bookName );
        rentResponse.userName( userName );

        return rentResponse.build();
    }
}
