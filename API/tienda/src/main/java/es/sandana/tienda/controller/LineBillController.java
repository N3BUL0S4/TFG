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

import es.sandana.tienda.dto.ResponseLineBillDTO;
import es.sandana.tienda.service.LineBillService;


@RestController
@RequestMapping("/LineBill")
@CrossOrigin(origins = "http://localhost:4200")
public class LineBillController {

	@Autowired
	private LineBillService lineBillService;

	@GetMapping("/findById")
	public ResponseEntity<ResponseLineBillDTO> getLineBillById(@RequestParam  Long lineBillId) {

		ResponseLineBillDTO LineBill = lineBillService.getLineBillById(lineBillId);
		return LineBill != null ? ResponseEntity.ok(LineBill) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@GetMapping("/findAll")
	public ResponseEntity<List<ResponseLineBillDTO>> getAllLineBill() {

		List<ResponseLineBillDTO> LineBill = lineBillService.getAllLineBill();
		return LineBill != null ? ResponseEntity.ok(LineBill) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PostMapping("/create")
	public ResponseEntity<ResponseLineBillDTO> createLineBill(@RequestBody ResponseLineBillDTO LineBillDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(lineBillService.createLineBill(LineBillDTO));
	}
}
