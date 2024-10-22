package es.sandana.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sandana.tienda.dto.ResponseLineCartDTO;
import es.sandana.tienda.entity.LineCartEntity;
import es.sandana.tienda.mapper.LineCartMapper;
import es.sandana.tienda.repository.LineCartRepository;


@Service
public class LineCartService {
	@Autowired
	private LineCartRepository lineCartRepository;

	@Autowired
	private LineCartMapper lineCartMapper;

	public ResponseLineCartDTO getLineCartById(Long id) {

		Optional<LineCartEntity> LineCartEntity = lineCartRepository.findById(id);
		ResponseLineCartDTO LineCartDTO = null;

		if(LineCartEntity.isPresent()) {
			LineCartDTO =lineCartMapper.LineCartEntityToDto(LineCartEntity.get());
		}

		return LineCartDTO;

	}

	public List<ResponseLineCartDTO> getAllLineCart() {

		List<LineCartEntity> LineCartEntity = lineCartRepository.findAll();
		List<ResponseLineCartDTO> LineCartDTO = null;

		if(!LineCartEntity.isEmpty()) {
			LineCartDTO = lineCartMapper.LineCartEntityToDtoList(LineCartEntity);
		}

		return LineCartDTO;

	}
	
	public List<ResponseLineCartDTO> getAllLineCartByCartId(Long cartId) {

		List<LineCartEntity> LineCartEntity = lineCartRepository.findLineCartByCartId(cartId);
		List<ResponseLineCartDTO> LineCartDTO = null;

		if(!LineCartEntity.isEmpty()) {
			LineCartDTO = lineCartMapper.LineCartEntityToDtoList(LineCartEntity);
		}

		return LineCartDTO;

	}

	public ResponseLineCartDTO createLineBill(ResponseLineCartDTO LineCart) {
		LineCartEntity CartCreated = lineCartRepository.save(lineCartMapper.LineCartDtoToEntity(LineCart));
		return lineCartMapper.LineCartEntityToDto(CartCreated);
	}


}
