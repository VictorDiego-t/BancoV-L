package com.vlbank.services;

import com.vlbank.domain.user.User;
import com.vlbank.domain.user.UserType;
import com.vlbank.dtos.UserDTO;
import com.vlbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuario Lojista não pode fazer transações");
        }
        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo Insuficiente");
        }
    }
    public User findUserById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Usuário com ID " + id + " não encontrado"));
    }

    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }

    public void saveUser(User user){
        this.repository.save(user);
    }

}
