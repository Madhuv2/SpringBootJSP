package com.yash.service;

import com.yash.model.User;
//import com.yash.repository.UserRepository;
import com.yash.model.UserDetail;
import com.yash.repository.UserDetailRepository;
import com.yash.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@ComponentScan(basePackages = "com.yash")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailRepository userDetailRepository;
    @Override
    public void authenticate(User user) {

    }

    @Override
    public void register(User user) {
//        UserDetail userDetail =new UserDetail();
//        user.setUserDetail(userDetail);
        userRepository.save(user);



    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();
         userRepository.findAll().forEach(users:: add);
        return users;

    }

}
