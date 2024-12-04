package es.sandana.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sandana.tienda.dto.ResponseLineBillDTO;
import es.sandana.tienda.entity.LineBillEntity;
import es.sandana.tienda.mapper.LineBillMapper;
import es.sandana.tienda.repository.LineBillRepository;

@Service
public class LineBillService {

	@Autowired
	private LineBillRepository lineBillRepository;

	@Autowired
	private LineBillMapper lineBillMapper;

	public ResponseLineBillDTO getLineBillById(Long id) {

		Optional<LineBillEntity> LineBillEntity = lineBillRepository.findById(id);
		ResponseLineBillDTO LineBillDTO = null;

		if(LineBillEntity.isPresent()) {
			LineBillDTO =lineBillMapper.LineBillEntityToDto(LineBillEntity.get());
		}

		return LineBillDTO;

	}

	public List<ResponseLineBillDTO> getAllLineBill() {

		List<LineBillEntity> LineBillEntity = lineBillRepository.findAll();
		List<ResponseLineBillDTO> LineBillDTO = null;

		if(!LineBillEntity.isEmpty()) {
			LineBillDTO = lineBillMapper.LineBillEntityToDtoList(LineBillEntity);
		}

		return LineBillDTO;

	}

	
	
	public ResponseLineBillDTO createLineBill(ResponseLineBillDTO LineBill) {
		LineBillEntity BillCreated = lineBillRepository.save(lineBillMapper.LineBillDtoToEntity(LineBill));
		return lineBillMapper.LineBillEntityToDto(BillCreated);
	}


}
