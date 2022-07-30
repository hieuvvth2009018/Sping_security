package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Credential;
import com.example.demo.entity.dto.AccountLoginDto;
import com.example.demo.entity.dto.AccountRegisterDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {
    @Autowired
    AccountService accountService;
    @Test

     void register(){
        AccountRegisterDto accountRegisterDto = new AccountRegisterDto();
        accountRegisterDto.setUsername("TienDung");
        accountRegisterDto.setGetPassword("123456");
        accountRegisterDto.setRole(1);
        AccountRegisterDto afterCreate = accountService.register(accountRegisterDto);
        System.out.println(afterCreate);
    }

    @Test
    void login(){
        AccountLoginDto accountLoginDto = new AccountLoginDto();
        accountLoginDto.setUsername("TienDung");
        accountLoginDto.setPassword("123456");
        Credential credential = new Credential();
        System.out.println(credential.toString());
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//        Optional<Account> optionalAccount = accountRepository.findAccountByUsername(username);
//        if (!optionalAccount.isPresent()){
//            throw new UsernameNotFoundException("User name is not found");
//        }
//        Account account = optionalAccount.get();
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(account.getRole() == 1 ? "ADMIN" : "USER");
//        authorities.add(simpleGrantedAuthority);
//        return new User(account.getUsername(), account.getPasswordHash(), authorities);
//    }

}