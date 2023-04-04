package com.example.appEcomerce.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class HelloSecuritycontrollerTest {
    private final String BASE_URL = "/hello";
    @Autowired
    private MockMvc mockMvc;
    @Test
    @WithMockUser(authorities = "ADMIN")
    public void givenCallGet_thenCalledMethodHello_thenReturnStatusCodeOk()throws Exception{
    mockMvc.perform(get(BASE_URL)).andDo(print()).andExpect(status().isOk());
    }
    @Test
    @WithMockUser(authorities = "READ")
    public void givenCallGet_thenCalledMethodHello_thenReturnStatusCode403()throws Exception{
        mockMvc.perform(get(BASE_URL)).andDo(print()).andExpect(status().isForbidden());
    }
}