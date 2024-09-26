package es.sandana.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import es.sandana.tienda.entity.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity,Long> {

    @Query
    List<CartEntity> findByArticleId(Long articleId);
    
}