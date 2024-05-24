package es.sandana.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sandana.demo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    
}