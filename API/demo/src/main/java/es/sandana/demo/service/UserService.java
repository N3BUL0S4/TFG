package es.sandana.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sandana.demo.dto.ResponseUserDTO;
import es.sandana.demo.entity.UserEntity;
import es.sandana.demo.mapper.UserMapper;
import es.sandana.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository UserRepository;
	
	@Autowired
	private UserMapper UserMapper;
	
	public ResponseUserDTO getUserById(Long UserId) {
		
		Optional<UserEntity> UserEntity = UserRepository.findById(UserId);
		ResponseUserDTO UserDTO = null;
		
		if(UserEntity.isPresent()) {
			UserDTO =UserMapper.UserEntityToDto(UserEntity.get());
		}
		
		return UserDTO;
		
	}
	
	public ResponseUserDTO createUser(ResponseUserDTO User) {		
		UserEntity UserCreated = UserRepository.save(UserMapper.UserDtoToEntity(User));
		return UserMapper.UserEntityToDto(UserCreated);
	}
}
