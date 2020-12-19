package com.example.backend.web.dto.mapper;

import com.example.backend.business.entity.UserEntity;
import com.example.backend.web.dto.create.CreateUserDto;
import com.example.backend.web.dto.update.UserUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public abstract class UserMapper {

    public UserEntity toNewEntity(CreateUserDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername( dto.getUsername() );
        userEntity.setEmail( dto.getEmail() );
        userEntity.setEnabled(true);
        userEntity.setPassword( dto.getPassword() );
        userEntity.setAccountConfirmed(true);
        userEntity.setBalanceOfCookies(0);

        return userEntity;
    }

    @Mapping(target = "id", ignore = true)
    public abstract void fromUpdateDto(@MappingTarget UserEntity userEntity, UserUpdateDto dto);

}
