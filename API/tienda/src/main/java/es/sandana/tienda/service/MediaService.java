package es.sandana.tienda.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.sandana.tienda.dto.ResponseMediaDTO;
import es.sandana.tienda.entity.MediaEntity;
import es.sandana.tienda.mapper.MediaMapper;
import es.sandana.tienda.repository.MediaRepository;


@Service
public class MediaService {

	@Autowired
	private MediaRepository mediaRepository;
	
	@Autowired
	private MediaMapper mediaMapper;
	
	public List<ResponseMediaDTO> getMediaByArticleId(Long articleId) {
		
		List<MediaEntity> mediaEntity = mediaRepository.findByArticleId(articleId);
		List<ResponseMediaDTO> mediaDTO = null;
		
		if(!mediaEntity.isEmpty()) {
			mediaDTO = mediaMapper.MediaEntityToDtoList(mediaEntity);
		}
		
		return mediaDTO;
		
	}

	public List<ResponseMediaDTO> getAllMedia() {
		
		List<MediaEntity> MediaEntity = mediaRepository.findAll();
		List<ResponseMediaDTO> MediasDTO = null;
		
		if(!MediaEntity.isEmpty()) {
			MediasDTO = mediaMapper.MediaEntityToDtoList(MediaEntity);
		}
		
		return MediasDTO;
		
	}
	
	public ResponseMediaDTO createMedia(ResponseMediaDTO media) {		
		MediaEntity mediaCreated = mediaRepository.save(mediaMapper.MediaDtoToEntity(media));
		return mediaMapper.MediaEntityToDto(mediaCreated);
	}
}
