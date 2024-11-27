package es.sandana.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import es.sandana.tienda.entity.LineCartEntity;

@Repository
public interface LineCartRepository extends JpaRepository<LineCartEntity,Long>{
	
	@Query
	List<LineCartEntity> findLineCartByCartId(Long cartId);
}
