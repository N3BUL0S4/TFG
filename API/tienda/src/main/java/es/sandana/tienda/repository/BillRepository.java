package es.sandana.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sandana.tienda.entity.BillEntity;

public interface BillRepository extends JpaRepository<BillEntity,Long> {

}
