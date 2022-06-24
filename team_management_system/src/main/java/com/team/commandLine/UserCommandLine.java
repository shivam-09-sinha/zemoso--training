package com.team.commandLine;

import com.team.dao.*;
import com.team.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLine implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User user_check = userRepository.findByUserName("shiva");
        if (user_check == null) {
            User user = new User();
            user.setUserName("shiva");
            user.setPassword(bCryptPasswordEncoder.encode("password"));
            user.setEmail("shiva124@gmail.com");
            user.setRole(User.Role.valueOf("admin"));
            userRepository.save(user);
        }
    }
}
