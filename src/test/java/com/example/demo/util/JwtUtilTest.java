package com.example.demo.util;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.entity.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {
    @Test
    public void testGenerateToken() {
//        String accceptToken = JwtUtil.generateToken("12312312", "USER", "T2009M1", 7);
//        System.out.println(accceptToken);
//        DecodedJWT decodedJWT = JwtUtil.getVerifier().verify(accceptToken);
//        System.out.println(decodedJWT.getSubject());
//        System.out.println(decodedJWT.getIssuer());
//        System.out.println(decodedJWT.getExpiresAt());

        Account account = Account.builder()
                .id(System.currentTimeMillis())
                .role(1)
                .username("TienDung123")
                .passwordHash("xzy")
                .build();
        String accessToken = JwtUtil.generateTokenByAccount(account, 15 * 24 * 60 * 60 * 1000);
        System.out.println(accessToken);




//        Account account = Account.builder()
//                .id(System.currentTimeMillis())
//                .role(1)
//                .username("DungNguyen123")
//                .passwordHash("xyz")
//                .build();
//        String accceptTokenAccount = JwtUtil.generateToken("")
    }

}