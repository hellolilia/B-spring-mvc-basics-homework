package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UsernameExistException;
import com.thoughtworks.capacity.gtb.mvc.exception.WrongUserException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public User loginUser(String username, String password) {
        List<User> users = userMap.values().stream()
                .filter(user -> user.getUsername().equals(username))
                .filter(user -> user.getPassword().equals(password))
                .collect(Collectors.toList());
        if (users.size() == 0) {
            throw new WrongUserException("用户名或密码错误");
        } else {
            return users.get(0);
        }
    }
}
