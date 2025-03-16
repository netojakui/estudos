package br.com.geosapiens.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
    public static String hashPassword(String rawPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(rawPassword);
    }

    public static void main(String[] args) {
        String senhaCriptografada = hashPassword("123");
        System.out.println(senhaCriptografada);
    }
}
