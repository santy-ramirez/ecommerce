package com.example.appEcomerce.mapper;

import com.example.appEcomerce.Domain.Products;
import com.example.appEcomerce.dto.ProductDto;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface ProductMapper {
    Products productDtoToProduct(ProductDto productDto);
    ProductDto productToProductDto(Products producs);
}
