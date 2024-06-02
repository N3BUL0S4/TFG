package es.sandana.tienda.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.sandana.tienda.entity.MediaEntity;

@Repository
public interface MediaRepository extends JpaRepository<MediaEntity,Long> {

    @Query
    List<MediaEntity> findByArticleId(Long articleId);
    
}