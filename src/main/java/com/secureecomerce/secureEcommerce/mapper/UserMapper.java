package com.secureecomerce.secureEcommerce.mapper;

import com.secureecomerce.secureEcommerce.dto.UserDto;
import com.secureecomerce.secureEcommerce.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    //UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
