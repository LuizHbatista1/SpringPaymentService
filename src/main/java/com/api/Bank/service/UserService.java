package com.api.Bank.service;

import com.api.Bank.domain.user.User;
import com.api.Bank.domain.user.UserType;
import com.api.Bank.dtos.UserDTO;
import com.api.Bank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender , BigDecimal amount) throws Exception {

        if(sender.getUserType() == UserType.COMMON){

            throw new Exception("error this action not be available");

        }

        if(sender.getBalance().compareTo(amount) > 0){

            throw  new Exception("error this action not be available");

        }

    }

    public User findUserById(Long id) throws Exception {

        return this.repository.findById(id).orElseThrow(()-> new Exception("error this action not be available"));

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
