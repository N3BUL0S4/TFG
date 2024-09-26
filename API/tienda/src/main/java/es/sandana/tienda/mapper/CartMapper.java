package es.sandana.tienda.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import es.sandana.tienda.dto.ResponseCartDTO;
import es.sandana.tienda.entity.CartEntity;

@Mapper(componentModel = "spring")
public interface CartMapper {
	
	ResponseCartDTO CartEntityToDto(CartEntity CartEntity);
	
	CartEntity CartDtoToEntity(ResponseCartDTO CartDto);
	
	List<ResponseCartDTO> CartEntityToDtoList(List<CartEntity> CartEntity);
	
	List<CartEntity> CartDtoToEntityList(List<ResponseCartDTO> CartDto);
}
