package com.example.demo.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Credential {
    private String accessToken;
    private String RefreshToken;
    private long expiredAt;
    private String scope;
}
