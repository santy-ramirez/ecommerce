package com.example.appEcomerce.service;

import com.example.appEcomerce.Domain.Products;
import com.example.appEcomerce.dto.ProductDto;
import com.example.appEcomerce.mapper.ProductMapper;
import com.example.appEcomerce.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductsService {
   private  final ProductsRepository productsRepository;
   private final ProductMapper productMapper;

   public ProductDto createProduct( ProductDto productDto){
       Products products = productMapper.productDtoToProduct(productDto);
       return productMapper.productToProductDto(productsRepository.save(products));
   }

    public List<ProductDto> getAllProducts(Boolean todo) {
       if (todo==true){
           List<Products>  productsEntity = productsRepository.findAll();

       return productsEntity.stream().map(productMapper::productToProductDto).collect(Collectors.toList());
       }
       return new ArrayList<>();
       }
}
