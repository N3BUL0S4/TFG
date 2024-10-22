package es.sandana.tienda.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import es.sandana.tienda.dto.ResponseLineBillDTO;
import es.sandana.tienda.entity.LineBillEntity;

@Mapper(componentModel = "spring")
public interface LineBillMapper {

	ResponseLineBillDTO LineBillEntityToDto(LineBillEntity LineBillEntity);

	LineBillEntity LineBillDtoToEntity(ResponseLineBillDTO LineBillDto);

	List<ResponseLineBillDTO> LineBillEntityToDtoList(List<LineBillEntity> LineBillEntity);

	List<LineBillEntity> LineBillDtoToEntityList(List<ResponseLineBillDTO> LineBillDto);
}
