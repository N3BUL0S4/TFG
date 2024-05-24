package es.sandana.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import es.sandana.demo.dto.ResponseUserDTO;
import es.sandana.demo.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	ResponseUserDTO UserEntityToDto(UserEntity UserEntity);
	
	UserEntity UserDtoToEntity(ResponseUserDTO UserDto);
	
	List<ResponseUserDTO> UserEntityToDto(List<UserEntity> UserEntity);
	
	List<UserEntity> UserDtoToEntity(List<ResponseUserDTO> UserEntity);
}

