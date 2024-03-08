package com.dozdugan.MovieApp.controller;

import com.dozdugan.MovieApp.dto.request.UserRequest;
import com.dozdugan.MovieApp.dto.response.UserResponse;
import com.dozdugan.MovieApp.model.User;
import com.dozdugan.MovieApp.model.WatchList;
import com.dozdugan.MovieApp.service.UserService;
import com.dozdugan.MovieApp.service.WatchlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/v1/api/users")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping()
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }

    @GetMapping()
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id,@RequestBody UserRequest userRequest){
        return userService.updateUser(id,userRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }


}
