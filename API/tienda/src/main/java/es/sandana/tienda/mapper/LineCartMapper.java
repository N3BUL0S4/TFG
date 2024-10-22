package es.sandana.tienda.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import es.sandana.tienda.dto.ResponseLineCartDTO;
import es.sandana.tienda.entity.LineCartEntity;

@Mapper(componentModel = "spring")
public interface LineCartMapper {
	
	ResponseLineCartDTO LineCartEntityToDto(LineCartEntity LineCartEntity);

	LineCartEntity LineCartDtoToEntity(ResponseLineCartDTO LineCartDTO);

	List<ResponseLineCartDTO> LineCartEntityToDtoList(List<LineCartEntity> LineCartEntity);

	List<LineCartEntity> LineCartDtoToEntityList(List<ResponseLineCartDTO> LineCartDTO);
}
