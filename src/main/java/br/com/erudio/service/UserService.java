package br.com.erudio.service;

import java.util.List;

import br.com.erudio.domain.Role;
import br.com.erudio.domain.User;

public interface UserService {
    
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String rolename);
    User getUser(String username);
    List<User> getUsers();
}
