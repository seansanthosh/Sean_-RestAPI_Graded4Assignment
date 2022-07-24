package com.greatlearning.empmanagement.event.controller;

import com.greatlearning.empmanagement.event.entity.UserData;
import com.greatlearning.empmanagement.event.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value="/add")
    public UserData addUser(@RequestBody UserData user){
        return userService.addUser(user);
    }

    @GetMapping("/")
    public List<UserData> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping(value="/delete/{id}")
    public void deleteUserById(@PathVariable Long id){
       userService.deleteBYId(id);
    }

}
