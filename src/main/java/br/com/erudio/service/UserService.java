package br.com.erudio.service;

import java.util.List;

import br.com.erudio.domain.Role;
import br.com.erudio.domain.User;

public interface UserService {
    public User saveUser(User user);
    public Role saveRole(Role role);
    public void addRoleToUser(String username, String roleName);
    public User getUser(String username);
    public List<User> getUsers();
}
