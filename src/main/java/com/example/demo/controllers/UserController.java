package com.example.demo.controllers;

import com.example.demo.clients.RequestClient;
import com.example.demo.model.response.CreateUserResponse;
import com.example.demo.model.response.MultipleUserResponse;
import com.example.demo.model.response.SingleUserResponse;
import com.example.demo.model.response.UpdateUserResponse;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    private final RequestClient requestClient;

    public UserController(RequestClient requestClient) {
        this.requestClient = requestClient;
    }

    @GetMapping("/user/{id}")
    public SingleUserResponse getUser(@PathVariable String id) {
        return requestClient.getUser(id);
    }

    @GetMapping("/users")
    public MultipleUserResponse getUsers(@RequestParam(required = false) Integer page) {
        return requestClient.listUsers(page);
    }

    @PostMapping("/user")
    public CreateUserResponse createUser(@RequestParam String name, @RequestParam String job) {
        Map<String, String> user = new HashMap<>();
        user.put("name", name);
        user.put("job", job);
        return requestClient.createUser(user);
    }

    @PutMapping("/user/{id}")
    public UpdateUserResponse updateUser(@PathVariable Integer id,
                                         @RequestParam String name,
                                         @RequestParam String job) {
        Map<String, String> user = new HashMap<>();
        user.put("name", name);
        user.put("job", job);
        return requestClient.updateUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id){
        requestClient.deleteUser(id);
    }
}