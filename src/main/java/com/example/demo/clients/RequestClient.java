package com.example.demo.clients;

import com.example.demo.model.response.CreateUserResponse;
import com.example.demo.model.response.MultipleUserResponse;
import com.example.demo.model.response.SingleUserResponse;
import com.example.demo.model.response.UpdateUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "request-client", url = "https://reqres.in")
public interface RequestClient {
    @GetMapping(value = "/api/users", headers = "x-api-key=reqres-free-v1")
    MultipleUserResponse listUsers(@RequestParam(name = "page", required = false) Integer page);

    @GetMapping(value = "/api/users/{id}", headers = "x-api-key=reqres-free-v1")
    SingleUserResponse getUser(@PathVariable(name = "id") String id);

    @PostMapping(value = "/api/users", headers = "x-api-key=reqres-free-v1")
    CreateUserResponse createUser(@RequestBody Map<String, String> user);

    @PutMapping(value = "/api/users/{id}", headers = "x-api-key=reqres-free-v1")
    UpdateUserResponse updateUser(@PathVariable(name = "id") Integer id, @RequestBody Map<String, String> user);

    @DeleteMapping(value = "/api/users/{id}", headers = "x-api-key=reqres-free-v1")
    void deleteUser(@PathVariable(name = "id") Integer id);
}