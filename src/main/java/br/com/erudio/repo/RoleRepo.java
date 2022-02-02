package br.com.erudio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erudio.domain.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    public Role findByName(String name);
}
