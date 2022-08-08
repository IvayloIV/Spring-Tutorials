package com.pluralsight.springbootjsp.services;

import com.pluralsight.springbootjsp.model.User;
import com.pluralsight.springbootjsp.repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaRepository userRepository;

    @Transactional
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
