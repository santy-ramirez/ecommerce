package com.example.appEcomerce.controller;


import com.example.appEcomerce.dto.CustomerPageDto;
import com.example.appEcomerce.dto.ProductDto;
import com.example.appEcomerce.service.ProductsService;
import com.example.appEcomerce.util.page.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductsController {
private final ProductsService productsService;


    @PostMapping
    public ResponseEntity<ProductDto>  addProducts(@RequestBody ProductDto productDto){
    return new ResponseEntity<>(productsService.createProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public CustomerPageDto getProducts(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                       @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                       @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
                                       @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir

    ){
        return productsService.getAllProducts(pageNo,pageSize,sortBy,sortDir);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String,Object>> deleteProducts(@PathVariable Long id ){
        return new ResponseEntity<>(productsService.deleteProduct(id),HttpStatus.OK);
    }



}
