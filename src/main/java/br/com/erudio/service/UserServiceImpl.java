package br.com.erudio.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.erudio.domain.Role;
import br.com.erudio.domain.User;
import br.com.erudio.repository.RoleRepository;
import br.com.erudio.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if(user == null) {
            logger.error("User not found in the database!");
            throw new UsernameNotFoundException("User not found in the database!");
        } else {
            logger.info("User found in the database: {}!", userName);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        
        return new org.springframework.security.core.userdetails.User(
                  user.getName(), user.getPassword(), authorities);
    }
    
    @Override
    public User saveUser(User user) {
        logger.info("Saving new user {} to the database!", user.getName());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        logger.info("Saving new role {} to the database!", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        logger.info("Adding role {} to user {} in the database!", roleName, username);
        User user = userRepository.findByUserName(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        logger.info("Fetching user {}!", username);
        return userRepository.findByUserName(username);
    }

    @Override
    public List<User> getUsers() {
        logger.info("Fetching all users!");
        return userRepository.findAll();
    }
}