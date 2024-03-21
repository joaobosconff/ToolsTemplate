package jb.estudo.ferramentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import jb.estudo.ferramentas.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{


    Optional<UserDetails> findByLogin(String login);

    Boolean existsUserByLogin(String login);

}
