package es.sandana.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sandana.tienda.dto.ResponseUserDTO;
import es.sandana.tienda.entity.UserEntity;
import es.sandana.tienda.mapper.UserMapper;
import es.sandana.tienda.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	public ResponseUserDTO getUserById(String email) {
		
		Optional<UserEntity> userEntity = userRepository.findById(email);
		ResponseUserDTO userDTO = null;
		
		if(userEntity.isPresent()) {
			userDTO =userMapper.UserEntityToDto(userEntity.get());
		}
		
		return userDTO;
		
	}

	public List<ResponseUserDTO> getAllUser() {
		
		List<UserEntity> userEntity = userRepository.findAll();
		List<ResponseUserDTO> usersDTO = null;
		
		if(!userEntity.isEmpty()) {
			usersDTO = userMapper.UserEntityToDtoList(userEntity);
		}
		
		return usersDTO;
		
	}
	
	public ResponseUserDTO createUser(ResponseUserDTO user) {		
		UserEntity userCreated = userRepository.save(userMapper.UserDtoToEntity(user));
		return userMapper.UserEntityToDto(userCreated);
	}
}
