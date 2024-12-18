package com.digital_libary.Digital_Library.sale.mapper;

import com.digital_libary.Digital_Library.sale.dto.SaleRequest;
import com.digital_libary.Digital_Library.sale.dto.SaleResponse;
import com.digital_libary.Digital_Library.sale.entity.Sale;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-18T04:16:57-0800",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class SaleMapperImpl implements SaleMapper {

    @Override
    public SaleResponse toDto(Sale saleResponse) {
        if ( saleResponse == null ) {
            return null;
        }

        SaleResponse.SaleResponseBuilder saleResponse1 = SaleResponse.builder();

        saleResponse1.fkBookId( saleResponse.getFkBookId() );
        saleResponse1.fkUserId( saleResponse.getFkUserId() );
        saleResponse1.fkSalesmanId( saleResponse.getFkSalesmanId() );
        saleResponse1.fkPaymentId( saleResponse.getFkPaymentId() );
        saleResponse1.totalAmount( saleResponse.getTotalAmount() );
        saleResponse1.saleDate( saleResponse.getSaleDate() );
        saleResponse1.count( saleResponse.getCount() );
        saleResponse1.salePrice( saleResponse.getSalePrice() );
        saleResponse1.discount( saleResponse.getDiscount() );
        saleResponse1.type( saleResponse.getType() );

        return saleResponse1.build();
    }

    @Override
    public Sale toEntity(SaleRequest saleRequest) {
        if ( saleRequest == null ) {
            return null;
        }

        Sale.SaleBuilder sale = Sale.builder();

        sale.fkBookId( saleRequest.getFkBookId() );
        sale.fkUserId( saleRequest.getFkUserId() );
        sale.fkSalesmanId( saleRequest.getFkSalesmanId() );
        sale.fkPaymentId( saleRequest.getFkPaymentId() );
        sale.saleDate( saleRequest.getSaleDate() );
        sale.count( saleRequest.getCount() );
        sale.salePrice( saleRequest.getSalePrice() );
        sale.totalAmount( saleRequest.getTotalAmount() );
        sale.discount( saleRequest.getDiscount() );
        sale.type( saleRequest.getType() );

        return sale.build();
    }

    @Override
    public void updateSaleFromDto(SaleRequest updateSale, Sale existingSale) {
        if ( updateSale == null ) {
            return;
        }

        existingSale.setFkBookId( updateSale.getFkBookId() );
        existingSale.setFkUserId( updateSale.getFkUserId() );
        existingSale.setFkSalesmanId( updateSale.getFkSalesmanId() );
        existingSale.setFkPaymentId( updateSale.getFkPaymentId() );
        existingSale.setSaleDate( updateSale.getSaleDate() );
        existingSale.setCount( updateSale.getCount() );
        existingSale.setSalePrice( updateSale.getSalePrice() );
        existingSale.setTotalAmount( updateSale.getTotalAmount() );
        existingSale.setDiscount( updateSale.getDiscount() );
        existingSale.setType( updateSale.getType() );
    }
}
