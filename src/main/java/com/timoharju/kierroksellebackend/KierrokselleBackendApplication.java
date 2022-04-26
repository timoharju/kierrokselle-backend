package com.timoharju.kierroksellebackend;

import com.timoharju.kierroksellebackend.models.Role;
import com.timoharju.kierroksellebackend.models.User;
import com.timoharju.kierroksellebackend.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class KierrokselleBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(KierrokselleBackendApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

