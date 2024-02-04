package jb.estudo.ferramentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jb.estudo.ferramentas.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{ 

}
