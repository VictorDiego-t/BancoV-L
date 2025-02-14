package com.vlbank.services;

import com.vlbank.domain.user.User;
import com.vlbank.domain.user.UserType;
import com.vlbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.COMMON){
            throw new Exception("Usuario Lojista não pode fazer transações");
        }
        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo Insuficiente");
        }
    }
    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuario Não Encontrado"));
    }

    public void saveUser(User user){
        this.repository.save(user);
    }

}
