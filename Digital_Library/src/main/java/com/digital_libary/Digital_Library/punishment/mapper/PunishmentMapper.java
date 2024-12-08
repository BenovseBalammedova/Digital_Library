package com.digital_libary.Digital_Library.punishment.mapper;


import com.digital_libary.Digital_Library.punishment.dto.PunishmentRequest;
import com.digital_libary.Digital_Library.punishment.dto.PunishmentResponse;
import com.digital_libary.Digital_Library.punishment.entity.Punishment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "Spring")
public interface PunishmentMapper {

    PunishmentResponse toDto(Punishment punishmentResponse);

    Punishment toEntity(PunishmentRequest punishmentRequest);

    void updatePunishmentFromDto(PunishmentRequest updatePunishment, @MappingTarget Punishment existingPunishment);


}
