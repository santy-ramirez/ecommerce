package com.example.appEcomerce.controller;


import com.example.appEcomerce.dto.CustomerPageDto;
import com.example.appEcomerce.dto.ProductDto;
import com.example.appEcomerce.service.ProductsService;
import com.example.appEcomerce.util.page.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductsController {
private final ProductsService productsService;


    @PostMapping
    public ProductDto addProducts(@RequestBody ProductDto productDto){
    return productsService.createProduct(productDto);
    }

    @GetMapping()
    public CustomerPageDto getProducts(@RequestParam(required = false, defaultValue = "true") Boolean todo,
                                       @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                       @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                       @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
                                       @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir

    ){
        return productsService.getAllProducts(todo,pageNo,pageSize,sortBy,sortDir);
    }



}
