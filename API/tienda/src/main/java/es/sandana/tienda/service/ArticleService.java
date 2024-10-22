package es.sandana.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sandana.tienda.dto.ResponseArticleDTO;
import es.sandana.tienda.entity.ArticleEntity;
import es.sandana.tienda.mapper.ArticleMapper;
import es.sandana.tienda.repository.ArticleRepository;


@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private ArticleMapper articleMapper;

	public ResponseArticleDTO getArticleById(Long id) {

		Optional<ArticleEntity> ArticleEntity = articleRepository.findById(id);
		ResponseArticleDTO ArticleDTO = null;

		if(ArticleEntity.isPresent()) {
			ArticleDTO =articleMapper.ArticleEntityToDto(ArticleEntity.get());
		}

		return ArticleDTO;

	}

	public List<ResponseArticleDTO> getAllArticle() {

		List<ArticleEntity> ArticleEntity = articleRepository.findAll();
		List<ResponseArticleDTO> ArticlesDTO = null;

		if(!ArticleEntity.isEmpty()) {
			ArticlesDTO = articleMapper.ArticleEntityToDtoList(ArticleEntity);
		}

		return ArticlesDTO;

	}

	public ResponseArticleDTO createArticle(ResponseArticleDTO Article) {
		ArticleEntity ArticleCreated = articleRepository.save(articleMapper.ArticleDtoToEntity(Article));
		return articleMapper.ArticleEntityToDto(ArticleCreated);
	}
}
