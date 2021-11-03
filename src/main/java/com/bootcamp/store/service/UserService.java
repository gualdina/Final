package com.bootcamp.store.service;

import com.bootcamp.store.exception.UserNotFound;
import com.bootcamp.store.model.User;
import com.bootcamp.store.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, InvoiceService invoiceService) {
        this.userRepository = userRepository;
    }

    //get by id
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFound::new);
    }

    //update User
    public User updateUser(Long id, String userName, String password, int age) {
        User user = this.getUserById(id);
        user.setUserName(userName);
        user.setPassword(password);
        user.setAge(age);
        return userRepository.save(user);
    }

}
