package es.sandana.tienda.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import es.sandana.tienda.dto.ResponseUserDTO;
import es.sandana.tienda.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	ResponseUserDTO UserEntityToDto(UserEntity UserEntity);
	
	UserEntity UserDtoToEntity(ResponseUserDTO UserDto);
	
	List<ResponseUserDTO> UserEntityToDtoList(List<UserEntity> UserEntity);
	
	List<UserEntity> UserDtoToEntityList(List<ResponseUserDTO> UserDto);
}

