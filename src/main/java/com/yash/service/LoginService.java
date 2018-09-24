package com.yash.service;

import com.yash.model.User;
import com.yash.model.UserDetail;
import com.yash.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = "com.yash")
public interface LoginService {

    void authenticate(User user);

    void register(User user);

    List<User> getAllUsers();
}
