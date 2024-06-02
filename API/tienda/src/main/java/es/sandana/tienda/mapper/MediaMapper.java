package es.sandana.tienda.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import es.sandana.tienda.dto.ResponseMediaDTO;
import es.sandana.tienda.entity.MediaEntity;

@Mapper(componentModel = "spring")
public interface MediaMapper {
	
	ResponseMediaDTO MediaEntityToDto(MediaEntity MediaEntity);
	
	MediaEntity MediaDtoToEntity(ResponseMediaDTO MediaDto);
	
	List<ResponseMediaDTO> MediaEntityToDtoList(List<MediaEntity> MediaEntity);
	
	List<MediaEntity> MediaDtoToEntityList(List<ResponseMediaDTO> MediaDto);
}

