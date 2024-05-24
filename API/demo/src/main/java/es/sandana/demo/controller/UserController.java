package es.sandana.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.sandana.demo.service.UserService;
import es.sandana.demo.dto.ResponseUserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

public class UserController {
    @Autowired
	private UserService UserService;

	
	@Operation(summary = "Devuelve User pot id")
	@GetMapping("/findById")
	@Parameter(name = "UserId", description = "Identificador de User", required = true, example = "1")
	public ResponseEntity<ResponseUserDTO> getUserById(@RequestParam Long UserId) {

		ResponseUserDTO User = UserService.getUserById(UserId);
		return User != null ? ResponseEntity.ok(User) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseUserDTO> createUser(@RequestBody ResponseUserDTO UserDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(UserService.createUser(UserDTO));
	}
}
