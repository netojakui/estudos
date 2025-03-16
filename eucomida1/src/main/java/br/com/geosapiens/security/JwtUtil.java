package br.com.geosapiens.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = "CHAVE_SECRETA_SUPER_SEGUDA_DE_32_BYTES!!";
    private static final long EXPIRATION_TIME = 86400000; // 1 dia (em milissegundos)

    private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    // Gera um token JWT
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Valida um token JWT
    public static String validateToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (JwtException e) {
            return null; // Token inválido ou expirado
        }
    }
}