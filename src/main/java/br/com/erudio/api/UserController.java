package br.com.erudio.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.erudio.domain.Role;
import br.com.erudio.domain.User;
import br.com.erudio.form.RoleToUserForm;
import br.com.erudio.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(service.getUsers());
    }
    
    @RequestMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder
                         .fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(service.saveUser(user));
    }
    
    @RequestMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder
                             .fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(service.saveRole(role));
    }
    
    @RequestMapping("/role/addtouser")
    public ResponseEntity<Role> addRoleToUser(@RequestBody RoleToUserForm form) {
        service.addRoleToUser(form.getUserName(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}