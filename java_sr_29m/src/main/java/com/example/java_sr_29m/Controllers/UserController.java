package com.example.java_sr_29m.Controllers;

import com.example.java_sr_29m.BLL.Services.UserService.IUserService;
import com.example.java_sr_29m.DAL.Entities.User;
import com.example.java_sr_29m.DTO.UserDtos.CreateUserDto;
import com.example.java_sr_29m.DTO.UserDtos.UpdateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/getusers")
    public ResponseEntity<List<User>> GetAllUsers() {
        List<User> allUsers = userService.getUsers();

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @PostMapping(value = "/createuser")
    public ResponseEntity<String> CreateUser(@RequestBody CreateUserDto createUserDto) {
        String message = userService.addUser(createUserDto);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteuserbyid")
    public ResponseEntity<String> DeleteUserById(@RequestBody Long id) {
        String message = userService.deleteUserById(id);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping(value = "/updateuser")
    public ResponseEntity<String> UpdateNews(@RequestBody UpdateUserDto updateUserDto) {
        String message = userService.updateUser(updateUserDto);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
