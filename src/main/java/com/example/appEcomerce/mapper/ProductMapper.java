package com.example.appEcomerce.mapper;

import com.example.appEcomerce.Domain.Products;
import com.example.appEcomerce.Domain.Usuario;
import com.example.appEcomerce.dto.ProductDto;
import com.example.appEcomerce.dto.RequestProductDto;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    Products productDtoToProduct(ProductDto productDto);
    ProductDto productToProductDto(Products producs);

    RequestProductDto productToRequestProductDto(Products products);

    @Named("mapProduct")
     default List<Usuario> map(Long value) {
        Usuario usuario = new Usuario();
        usuario.setId(value);
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario);
        return  usuarios;
    }
    @Mappings( {
            @Mapping(source = "user", target = "users", qualifiedByName = "mapProduct")
    } )
    Products requestProductDtoToProduct(RequestProductDto requestProductDto);
}
