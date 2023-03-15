package com.example.appTestSpringSecurity.mapper;



import com.example.appTestSpringSecurity.Domain.Role;
import com.example.appTestSpringSecurity.Domain.Usuario;
import com.example.appTestSpringSecurity.dto.ResponseUserDto;
import com.example.appTestSpringSecurity.dto.UserDto;
import com.example.appTestSpringSecurity.util.ERole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
  @Mappings({
    @Mapping(target="authorities" ,source = "authoritie", qualifiedByName = "mapItems")
    
  })
    Usuario userDtoToUser(UserDto userDto);
 @Named("mapItems")
  default List<Role> map(Long value){
   Role rol = new Role();
   if(value == 1 ){
     rol.setName(ERole.ADMIN);
     rol.setId(value);
   }

   if(value == 2 ){
     rol.setName(ERole.READ);
     rol.setId(value);
   }
   if(value == 3 ){
     rol.setName(ERole.WRITE);
     rol.setId(value);
   }
    List<Role> roles = new ArrayList<>();
    roles.add(rol);
            return roles;
 }

 ResponseUserDto UserToResponseUserDto(Usuario usuario);
}
