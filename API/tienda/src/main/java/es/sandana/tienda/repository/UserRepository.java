package es.sandana.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.sandana.tienda.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {


    
}