package com.digital_libary.Digital_Library.punishment.mapper;

import com.digital_libary.Digital_Library.punishment.dto.PunishmentRequest;
import com.digital_libary.Digital_Library.punishment.dto.PunishmentResponse;
import com.digital_libary.Digital_Library.punishment.entity.Punishment;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-18T04:16:56-0800",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PunishmentMapperImpl implements PunishmentMapper {

    @Override
    public PunishmentResponse toDto(Punishment punishmentResponse) {
        if ( punishmentResponse == null ) {
            return null;
        }

        PunishmentResponse.PunishmentResponseBuilder punishmentResponse1 = PunishmentResponse.builder();

        if ( punishmentResponse.getUserId() != null ) {
            punishmentResponse1.userId( Long.parseLong( punishmentResponse.getUserId() ) );
        }
        if ( punishmentResponse.getBookId() != null ) {
            punishmentResponse1.bookId( Long.parseLong( punishmentResponse.getBookId() ) );
        }
        punishmentResponse1.price( punishmentResponse.getPrice() );
        punishmentResponse1.startDate( punishmentResponse.getStartDate() );
        punishmentResponse1.endDate( punishmentResponse.getEndDate() );
        punishmentResponse1.reason( punishmentResponse.getReason() );
        punishmentResponse1.status( punishmentResponse.getStatus() );
        punishmentResponse1.fineAmount( punishmentResponse.getFineAmount() );

        return punishmentResponse1.build();
    }

    @Override
    public Punishment toEntity(PunishmentRequest punishmentRequest) {
        if ( punishmentRequest == null ) {
            return null;
        }

        Punishment punishment = new Punishment();

        punishment.setUserId( punishmentRequest.getUserId() );
        punishment.setBookId( punishmentRequest.getBookId() );
        punishment.setPrice( punishmentRequest.getPrice() );
        punishment.setStartDate( punishmentRequest.getStartDate() );
        punishment.setEndDate( punishmentRequest.getEndDate() );
        punishment.setFineAmount( punishmentRequest.getFineAmount() );
        punishment.setReason( punishmentRequest.getReason() );
        punishment.setStatus( punishmentRequest.getStatus() );

        return punishment;
    }

    @Override
    public void updatePunishmentFromDto(PunishmentRequest updatePunishment, Punishment existingPunishment) {
        if ( updatePunishment == null ) {
            return;
        }

        existingPunishment.setUserId( updatePunishment.getUserId() );
        existingPunishment.setBookId( updatePunishment.getBookId() );
        existingPunishment.setPrice( updatePunishment.getPrice() );
        existingPunishment.setStartDate( updatePunishment.getStartDate() );
        existingPunishment.setEndDate( updatePunishment.getEndDate() );
        existingPunishment.setFineAmount( updatePunishment.getFineAmount() );
        existingPunishment.setReason( updatePunishment.getReason() );
        existingPunishment.setStatus( updatePunishment.getStatus() );
    }
}
