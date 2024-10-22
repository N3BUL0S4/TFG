package es.sandana.tienda.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import es.sandana.tienda.dto.ResponseBillDTO;
import es.sandana.tienda.entity.BillEntity;

@Mapper(componentModel = "spring")
public interface BillMapper {

	ResponseBillDTO BillEntityToDto(BillEntity BillEntity);

	BillEntity BillDtoToEntity(ResponseBillDTO BillDto);

	List<ResponseBillDTO> BillEntityToDtoList(List<BillEntity> BillEntity);

	List<BillEntity> BillDtoToEntityList(List<ResponseBillDTO> BillDto);
}
