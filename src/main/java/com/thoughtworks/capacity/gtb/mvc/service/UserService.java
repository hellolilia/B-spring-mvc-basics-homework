package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UsernameExistException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String, User> userMap = new HashMap<>();

    public void registerUser(User user) {
        if (userMap.containsKey(user.getUsername())) {
            throw new UsernameExistException("用户已存在");
        }
        user.setId(userMap.size()+1);
        userMap.put(user.getUsername(), user);
    }
}
