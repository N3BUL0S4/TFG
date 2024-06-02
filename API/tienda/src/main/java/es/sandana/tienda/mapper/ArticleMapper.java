package es.sandana.tienda.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import es.sandana.tienda.dto.ResponseArticleDTO;
import es.sandana.tienda.entity.ArticleEntity;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
	
	ResponseArticleDTO ArticleEntityToDto(ArticleEntity ArticleEntity);
	
	ArticleEntity ArticleDtoToEntity(ResponseArticleDTO ArticleDto);
	
	List<ResponseArticleDTO> ArticleEntityToDtoList(List<ArticleEntity> ArticleEntity);
	
	List<ArticleEntity> ArticleDtoToEntityList(List<ResponseArticleDTO> ArticleDto);
}

