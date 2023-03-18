package com.example.appEcomerce.util.page;

import com.example.appEcomerce.dto.CustomerPageDto;
import org.springframework.data.domain.Page;

public  class  CustomerConverterPages {
    public static CustomerPageDto toConverterPagination(Page<?> page){
        CustomerPageDto customerPageDto = new CustomerPageDto();
        customerPageDto.setContent(page.getContent());
        customerPageDto.setPageNo(page.getNumber());
        customerPageDto.setPageSize(page.getSize());
        customerPageDto.setTotalElements(page.getTotalElements());
        customerPageDto.setTotalPages(page.getTotalPages());
        customerPageDto.setLast(page.isLast());
        return customerPageDto;
    }
}
