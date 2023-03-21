package com.example.appEcomerce.controller;

import com.example.appEcomerce.service.ProductsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductsControllerTest {

private final String BASE_URI = "/products";
    @Autowired
   private MockMvc mockMvc;
    @Mock
    private ProductsService productsService;
    @Test
    public void givenProduct_whenSaveProduct_thenReturnStatus200  () throws Exception {
        mockMvc.perform(post(BASE_URI).
                contentType(MediaType.APPLICATION_JSON).
                content( "{\n" +
                "  \"name\": \"cerveza2\",\n" +
                "  \"category\": \"BEBIDAS\"\n" +
                "}")).
                andDo(print()).
                andExpect(status().isCreated());
    }
}