package com.tecnocampus.agile.users.service;

import com.tecnocampus.agile.users.model.User;
import com.tecnocampus.agile.users.model.UserList;
import com.tecnocampus.agile.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    final
    UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserList> getAllUsersShort(Pageable pagination) {
        return userRepository.findAllProjectedBy(pagination);
    }


    public User getById(String id) {
        return userRepository.findUserById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
