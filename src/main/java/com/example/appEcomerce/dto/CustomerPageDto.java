package com.example.appEcomerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPageDto {
    private int totalPages;
    private long totalElements;
    private int totalThePages;
    private int pageSize;
    private int pageNo;
    private boolean last;
    private List<ProductDto> content;
}
