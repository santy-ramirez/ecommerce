package com.example.appEcomerce.service;

import com.example.appEcomerce.Domain.Products;
import com.example.appEcomerce.dto.CustomerPageDto;
import com.example.appEcomerce.dto.ProductDto;
import com.example.appEcomerce.mapper.ProductMapper;
import com.example.appEcomerce.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    public CustomerPageDto getAllProducts(Boolean todo, int pageNo, int pageSize, String sortBy , String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Page<Products> productsPage = productsRepository.findAll(pageable);

        List<Products> products = productsPage.getContent();
        List<ProductDto> productDtos = products.stream().map(productMapper::productToProductDto).collect(Collectors.toList());

        CustomerPageDto customerPageDto = new CustomerPageDto();
        customerPageDto.setContent(productDtos);
        customerPageDto.setPageNo(productsPage.getNumber());
        customerPageDto.setPageSize(productsPage.getSize());
        customerPageDto.setTotalElements(productsPage.getTotalElements());
        customerPageDto.setTotalPages(productsPage.getTotalPages());
        customerPageDto.setLast(productsPage.isLast());
        return customerPageDto;
    }
}
