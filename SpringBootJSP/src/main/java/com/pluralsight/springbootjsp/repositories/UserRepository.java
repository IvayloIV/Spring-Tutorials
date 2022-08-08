package com.pluralsight.springbootjsp.repositories;

import com.pluralsight.springbootjsp.model.User;

public interface UserRepository {
    User save(User user);
}
