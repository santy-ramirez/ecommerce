package com.example.appEcomerce.service;

import com.example.appEcomerce.Domain.Producs;
import com.example.appEcomerce.dto.ProductDto;
import com.example.appEcomerce.mapper.ProductMapper;
import com.example.appEcomerce.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductsService {
   private  final ProductsRepository productsRepository;
   private final ProductMapper productMapper;

   public ProductDto createProduct( ProductDto productDto){
       Producs producs = productMapper.productDtoToProduct(productDto);
       return productMapper.productToProductDto(productsRepository.save(producs));
   }
}
