package com.example.appEcomerce.controller;

import com.example.appEcomerce.dto.RequestUserDto;
import com.example.appEcomerce.dto.UserDto;
import com.example.appEcomerce.service.ProductsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class UserControllerTest {

    private  final String BASE_URI = "/auth";
    @Mock
    private ProductsService productsService;

    private ObjectMapper objectMapper = new ObjectMapper();



    @Autowired
    private MockMvc mockMvc;
    @Test
    public void givenUser_whenCallMethodRegister_thenReturnStatusCode()throws Exception{
        UserDto requestUserDto = new UserDto();
        requestUserDto.setUsername("testUser");
        requestUserDto.setPassword("testpassword");
        requestUserDto.setAuthoritie(1L);

        String body = objectMapper.writeValueAsString(requestUserDto);
      String response=  mockMvc.perform(post(BASE_URI+"/register").
                        contentType(MediaType.APPLICATION_JSON).
                        content(body)).
                andDo(print()).andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
        log.info(response);
    }
}