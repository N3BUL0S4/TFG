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

import es.sandana.tienda.dto.ResponseLineCartDTO;
import es.sandana.tienda.service.LineCartService;


@RestController
@RequestMapping("/LineCart")
@CrossOrigin(origins = "http://localhost:4200")
public class LineCartController {
	
	@Autowired
	private LineCartService lineCartService;

	@GetMapping("/findById")
	public ResponseEntity<ResponseLineCartDTO> getLineCartById(@RequestParam  Long lineCartId) {

		ResponseLineCartDTO LineBill = lineCartService.getLineCartById(lineCartId);
		return LineBill != null ? ResponseEntity.ok(LineBill) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@GetMapping("/findAll")
	public ResponseEntity<List<ResponseLineCartDTO>> getAllLineCart() {

		List<ResponseLineCartDTO> LineCart = lineCartService.getAllLineCart();
		return LineCart != null ? ResponseEntity.ok(LineCart) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}
	
	@GetMapping("/findByCartId")
	public ResponseEntity<List<ResponseLineCartDTO>> getAllLineCartByCartId(@RequestParam Long cartId) {

		List<ResponseLineCartDTO> LineCart = lineCartService.getAllLineCartByCartId(cartId);
		return LineCart != null ? ResponseEntity.ok(LineCart) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PostMapping("/create")
	public ResponseEntity<ResponseLineCartDTO> createLineCart(@RequestBody ResponseLineCartDTO LineCartDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(lineCartService.createLineBill(LineCartDTO));
	}
}
