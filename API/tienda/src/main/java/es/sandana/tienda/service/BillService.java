package es.sandana.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sandana.tienda.dto.ResponseBillDTO;
import es.sandana.tienda.entity.BillEntity;
import es.sandana.tienda.mapper.BillMapper;
import es.sandana.tienda.repository.BillRepository;


@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private BillMapper billMapper;

	public ResponseBillDTO getBillById(Long id) {

		Optional<BillEntity> BillEntity = billRepository.findById(id);
		ResponseBillDTO BillDTO = null;

		if(BillEntity.isPresent()) {
			BillDTO =billMapper.BillEntityToDto(BillEntity.get());
		}

		return BillDTO;

	}

	public List<ResponseBillDTO> getAllBill() {

		List<BillEntity> BillEntity = billRepository.findAll();
		List<ResponseBillDTO> BillDTO = null;

		if(!BillEntity.isEmpty()) {
			BillDTO = billMapper.BillEntityToDtoList(BillEntity);
		}

		return BillDTO;

	}

	public ResponseBillDTO createBill(ResponseBillDTO Bill) {
		BillEntity BillCreated = billRepository.save(billMapper.BillDtoToEntity(Bill));
		return billMapper.BillEntityToDto(BillCreated);
	}


}
