package com.example.appEcomerce.service;

import com.example.appEcomerce.Domain.Products;
import com.example.appEcomerce.Domain.Usuario;
import com.example.appEcomerce.dto.CustomerPageDto;
import com.example.appEcomerce.dto.ProductDto;
import com.example.appEcomerce.exception.product.ProductNotFountException;
import com.example.appEcomerce.mapper.ProductMapper;
import com.example.appEcomerce.repository.ProductsRepository;
import com.example.appEcomerce.repository.UsuarioRepository;
import com.example.appEcomerce.util.ECategory;
import com.example.appEcomerce.util.page.CustomerConverterPages;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductsService {

   private  final ProductsRepository productsRepository;
   private final UsuarioRepository usuarioRepository;
   private final ProductMapper productMapper;

   public ProductDto createProduct(ProductDto productDto)throws Exception{
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       /*if(!authentication.isAuthenticated() & !authentication.getAuthorities().contains(ERole.ADMIN)){
           throw new RuntimeException("no esta autenticado");
       }*/
       Usuario userEntity = usuarioRepository.findByUsername(authentication.getName()).orElseThrow( ()-> new RuntimeException("not fount user"));
       Products products1 = productMapper.productDtoToProduct(productDto);
       products1.getUsers().add(userEntity);
       Products productsSaved =    productsRepository.save(products1);
       ProductDto productDto1 = productMapper.productToProductDto(productsSaved);
       return productDto1;
   }

    public CustomerPageDto getAllProducts( int pageNo, int pageSize, String sortBy , String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Page<Products> productsPage = productsRepository.findAll(pageable);
        return  CustomerConverterPages.toConverterPagination(productsPage);
    }


    public Map<String,Object> deleteProduct(Long id) throws Exception {
       Products products = productsRepository.findById(id).orElseThrow( () -> new ProductNotFountException("not Fount product number"+ id) );
       products.setSoftDelete(true);
       productsRepository.save(products);
       Map<String,Object> product = new HashMap<>();
       product.put("product", products);
       product.put("delete","on");
       return product;
   }

   public ProductDto updateProduct(ProductDto productDto) throws Exception {
     Products products=  productsRepository.findById(productDto.getId()).orElseThrow(()-> new  ProductNotFountException("not fount number"+ productDto.getName()));
     products.setName(productDto.getName());
     products.setCategory(ECategory.valueOf(productDto.getCategory()));
     ProductDto productDtos= productMapper.productToProductDto(products);
     return productDtos;
   }
}
