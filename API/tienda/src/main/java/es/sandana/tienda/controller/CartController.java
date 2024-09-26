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

import es.sandana.tienda.dto.ResponseCartDTO;
import es.sandana.tienda.service.CartService;

@RestController
@RequestMapping("/Cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
    @Autowired
	private CartService cartService;

	@GetMapping("/findByArticleId")
	public ResponseEntity<List<ResponseCartDTO>> getCartByArticleId(@RequestParam Long articleId) {

		List<ResponseCartDTO> cart = cartService.getCartByArticleId(articleId);
		return cart != null ? ResponseEntity.ok(cart) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ResponseCartDTO>> getAllCart() {

		List<ResponseCartDTO> cart = cartService.getAllCart();
		return cart != null ? ResponseEntity.ok(cart) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PostMapping("/create")
	public ResponseEntity<ResponseCartDTO> createMedia(@RequestBody ResponseCartDTO cartDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(cartService.createCart(cartDTO));
	}
}