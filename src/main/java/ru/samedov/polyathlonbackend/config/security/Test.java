package ru.samedov.polyathlonbackend.config.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10); // Strength set as 12
        String encodedPassword = encoder.encode("moderator");
        System.out.println(encodedPassword);
    }
}
