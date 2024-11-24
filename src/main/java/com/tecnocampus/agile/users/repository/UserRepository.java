package com.tecnocampus.agile.users.repository;

import com.tecnocampus.agile.users.model.User;
import com.tecnocampus.agile.users.model.UserList;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface UserRepository extends MongoRepository<User, String> {
    List<UserList> findAllProjectedBy(Pageable pageable);

    User findUserById(String id);
}
