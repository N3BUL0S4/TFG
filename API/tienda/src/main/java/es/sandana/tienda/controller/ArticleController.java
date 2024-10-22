package es.sandana.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.sandana.tienda.dto.ResponseArticleDTO;
import es.sandana.tienda.service.ArticleService;

@RestController
@RequestMapping("/Article")
@CrossOrigin(origins = "http://localhost:4200")
public class ArticleController {
    @Autowired
	private ArticleService articleService;

	@GetMapping("/findById")
	public ResponseEntity<ResponseArticleDTO> getArticleById(@RequestParam  Long articleId) {

		ResponseArticleDTO article = articleService.getArticleById(articleId);
		return article != null ? ResponseEntity.ok(article) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@GetMapping("/findAll")
	public ResponseEntity<List<ResponseArticleDTO>> getAllArticle() {

		List<ResponseArticleDTO> Articles = articleService.getAllArticle();
		return Articles != null ? ResponseEntity.ok(Articles) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PostMapping("/create")
	public ResponseEntity<ResponseArticleDTO> createArticle(@RequestBody ResponseArticleDTO articleDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(articleService.createArticle(articleDTO));
	}
}
