package com.example.appEcomerce.mapper;

import com.example.appEcomerce.Domain.Producs;
import com.example.appEcomerce.dto.ProductDto;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface ProductMapper {
    Producs productDtoToProduct(ProductDto productDto);
    ProductDto productToProductDto(Producs producs);
}
