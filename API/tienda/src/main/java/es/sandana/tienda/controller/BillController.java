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

import es.sandana.tienda.dto.ResponseBillDTO;
import es.sandana.tienda.service.BillService;

@RestController
@RequestMapping("/Bill")
@CrossOrigin(origins = "http://localhost:4200")
public class BillController {

	@Autowired
	private BillService billService;

	@GetMapping("/findById")
	public ResponseEntity<ResponseBillDTO> getBillById(@RequestParam  Long billId) {

		ResponseBillDTO bill = billService.getBillById(billId);
		return bill != null ? ResponseEntity.ok(bill) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@GetMapping("/findAll")
	public ResponseEntity<List<ResponseBillDTO>> getAllBill() {

		List<ResponseBillDTO> Bill = billService.getAllBill();
		return Bill != null ? ResponseEntity.ok(Bill) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PostMapping("/create")
	public ResponseEntity<ResponseBillDTO> createBill(@RequestBody ResponseBillDTO billDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(billService.createBill(billDTO));
	}
}
