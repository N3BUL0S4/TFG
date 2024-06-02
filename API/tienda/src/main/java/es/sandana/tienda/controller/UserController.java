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

import es.sandana.tienda.service.UserService;
import es.sandana.tienda.dto.ResponseUserDTO;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
	private UserService userService;

	@GetMapping("/findById")
	public ResponseEntity<ResponseUserDTO> getUserById(@RequestParam  String UserId) {

		ResponseUserDTO user = userService.getUserById(UserId);
		return user != null ? ResponseEntity.ok(user) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ResponseUserDTO>> getAllUser() {

		List<ResponseUserDTO> users = userService.getAllUser();
		return users != null ? ResponseEntity.ok(users) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PostMapping("/create")
	public ResponseEntity<ResponseUserDTO> createUser(@RequestBody ResponseUserDTO UserDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(UserDTO));
	}
}
