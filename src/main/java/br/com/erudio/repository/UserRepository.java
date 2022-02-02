package br.com.erudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erudio.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    User findByUsername(String username);
}
