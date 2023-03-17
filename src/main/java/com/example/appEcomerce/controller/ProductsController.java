package com.example.appEcomerce.controller;


import com.example.appEcomerce.dto.ProductDto;
import com.example.appEcomerce.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductsController {
private final ProductsService productsService;
    @GetMapping
    public String helloProducts(){
        return "hello products";
    }

    @PostMapping
    public ProductDto addProducts(@RequestBody ProductDto productDto){
    return productsService.createProduct(productDto);
    }


}
