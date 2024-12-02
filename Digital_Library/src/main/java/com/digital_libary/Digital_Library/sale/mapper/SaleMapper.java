package com.digital_libary.Digital_Library.sale.mapper;

import com.digital_libary.Digital_Library.sale.dto.SaleRequest;
import com.digital_libary.Digital_Library.sale.dto.SaleResponse;
import com.digital_libary.Digital_Library.sale.entity.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "Spring")
public interface SaleMapper {

    SaleResponse toDto(Sale saleResponse);

    Sale toEntity(SaleRequest saleRequest);

    void updateSaleFromDto(SaleRequest updateSale, @MappingTarget Sale existingSale);


}
