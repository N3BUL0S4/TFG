package es.sandana.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sandana.tienda.dto.ResponseCartDTO;
import es.sandana.tienda.entity.CartEntity;
import es.sandana.tienda.mapper.CartMapper;
import es.sandana.tienda.repository.CartRepository;


@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartMapper cartMapper;

	public ResponseCartDTO getCartByCartId(Long cartId) {

		CartEntity cartEntity = cartRepository.getById(cartId);
		ResponseCartDTO cartDTO = null;

		if(cartEntity != null) {
			cartDTO = cartMapper.CartEntityToDto(cartEntity);
		}

		return cartDTO;

	}
	
	public ResponseCartDTO findCartByUserId(String userId) {

		CartEntity cartEntity = cartRepository.findCartByUserId(userId);
		ResponseCartDTO cartDTO = null;

		if(cartEntity != null) {
			cartDTO = cartMapper.CartEntityToDto(cartEntity);
		}

		return cartDTO;

	}
	
	public List<ResponseCartDTO> getAllCart() {

		List<CartEntity> CartEntity = cartRepository.findAll();
		List<ResponseCartDTO> CartDTO = null;

		if(!CartEntity.isEmpty()) {
			CartDTO = cartMapper.CartEntityToDtoList(CartEntity);
		}

		return CartDTO;

	}
	
	public ResponseCartDTO createCart(ResponseCartDTO cart) {
		CartEntity cartCreated = cartRepository.save(cartMapper.CartDtoToEntity(cart));
		return cartMapper.CartEntityToDto(cartCreated);
	}
}

