package br.com.erudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erudio.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    
    Role findByName(String name);
}
