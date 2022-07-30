package com.example.demo.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountRegisterDto {
    public CharSequence getPassword;
    private long id;
    private String username;
    private String passwordHash;
    private int role; // 1.admin 2.user
}
