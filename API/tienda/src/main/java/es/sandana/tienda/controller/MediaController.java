package es.sandana.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.sandana.tienda.service.MediaService;
import es.sandana.tienda.dto.ResponseMediaDTO;

@RestController
@RequestMapping("/Media")
public class MediaController {
    @Autowired
	private MediaService mediaService;

	@GetMapping("/findByArticleId")
	public ResponseEntity<List<ResponseMediaDTO>> getMediaByArticleId(@RequestParam Long articleId) {

		List<ResponseMediaDTO> media = mediaService.getMediaByArticleId(articleId);
		return media != null ? ResponseEntity.ok(media) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ResponseMediaDTO>> getAllMedia() {

		List<ResponseMediaDTO> medias = mediaService.getAllMedia();
		return medias != null ? ResponseEntity.ok(medias) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PostMapping("/create")
	public ResponseEntity<ResponseMediaDTO> createMedia(@RequestBody ResponseMediaDTO mediaDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(mediaService.createMedia(mediaDTO));
	}
}
