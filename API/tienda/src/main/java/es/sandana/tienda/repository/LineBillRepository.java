package es.sandana.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.sandana.tienda.entity.LineBillEntity;

@Repository
public interface LineBillRepository extends JpaRepository<LineBillEntity,Long> {

}
