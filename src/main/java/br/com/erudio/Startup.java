package br.com.erudio;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.erudio.domain.Role;
import br.com.erudio.domain.User;
import br.com.erudio.service.UserService;

@SpringBootApplication
public class Startup {

    public static void main(String[] args) {
        SpringApplication.run(Startup.class, args);
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    CommandLineRunner run(UserService service) { 
        return args -> {
            service.saveRole(new Role(null, "ROLE_USER"));
            service.saveRole(new Role(null, "ROLE_MANAGER"));
            service.saveRole(new Role(null, "ROLE_ADMIN"));
            service.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
            
            service.saveUser(new User(null, "Johnny Cash", "johnny", "1234", new ArrayList<>()));
            service.saveUser(new User(null, "Dan McCafferty", "dan", "1234", new ArrayList<>()));
            service.saveUser(new User(null, "Tom Fogerty", "tom", "1234", new ArrayList<>()));
            service.saveUser(new User(null, "Wolf Hoffmann", "hoffmann", "1234", new ArrayList<>()));
            
            service.addRoleToUser("johnny", "ROLE_USER");
            service.addRoleToUser("johnny", "ROLE_MANAGER");
            service.addRoleToUser("dan", "ROLE_MANAGER");
            service.addRoleToUser("tom", "ROLE_ADMIN");
            service.addRoleToUser("hoffmann", "ROLE_SUPER_ADMIN");
            service.addRoleToUser("hoffmann", "ROLE_ADMIN");
            service.addRoleToUser("hoffmann", "ROLE_USER");
        };
    }

}
