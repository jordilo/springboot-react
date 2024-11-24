package com.tecnocampus.agile.users.api;

import com.tecnocampus.agile.users.model.User;
import com.tecnocampus.agile.users.model.UserList;
import com.tecnocampus.agile.users.service.UsersService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "api/users")
public class UsersController {


    final
    UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserList>> get(@RequestParam int page, @RequestParam int size) {
        try {
            Pageable pagination = PageRequest.of(page, size);
            return ResponseEntity.ok(usersService.getAllUsersShort(pagination));
        } catch (Exception e) {

            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping("")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        try {

            return ResponseEntity.ok(usersService.save(user));
        } catch (Exception e) {

            return ResponseEntity.badRequest().build();
        }

    }


    @GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable("id") String id) {

        return ResponseEntity.ok(usersService.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<User> saveUser(@PathVariable("id") String id, @RequestBody User user) {

        if (!user.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(usersService.save(user));
    }
}
