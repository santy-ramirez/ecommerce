package com.example.appEcomerce.service;

import com.example.appEcomerce.Domain.Products;
import com.example.appEcomerce.dto.CustomerPageDto;
import com.example.appEcomerce.dto.ProductDto;
import com.example.appEcomerce.mapper.ProductMapper;
import com.example.appEcomerce.repository.ProductsRepository;
import com.example.appEcomerce.util.page.CustomerConverterPages;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

    public CustomerPageDto getAllProducts( int pageNo, int pageSize, String sortBy , String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Page<Products> productsPage = productsRepository.findAll(pageable);
        return  CustomerConverterPages.toConverterPagination(productsPage);
    }


    public Map<String,Object> deleteProduct(Long id) {
       Products products = productsRepository.findById(id).orElseThrow( () -> new RuntimeException("not Fount product number"+ id) );
       products.setSoftDelete(true);
       productsRepository.save(products);
       Map<String,Object> product = new HashMap<>();
       product.put("product", products);
       product.put("delete","on");
       return product;
   }
}
