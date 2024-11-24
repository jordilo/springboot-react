package com.tecnocampus.agile.users.service;

import com.tecnocampus.agile.users.model.User;
import com.tecnocampus.agile.users.model.UserList;
import com.tecnocampus.agile.users.repository.UserRepository;
import com.tecnocampus.agile.utils.Pagination;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    final
    UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Pagination<UserList> getAllUsersShort(Pageable pagination) {
        var items = userRepository.findAllProjectedBy(pagination);
        var totalItems = userRepository.count();
        return Pagination.<UserList>builder()
                .pageSize(pagination.getPageSize())
                .currentPage(pagination.getPageNumber())
                .totalItems((int) totalItems)
                .items(items)
                .build();
    }


    public User getById(String id) {
        return userRepository.findUserById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
