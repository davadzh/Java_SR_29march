package com.example.java_sr_29m.BLL.Services.UserService;

import com.example.java_sr_29m.DAL.Entities.User;
import com.example.java_sr_29m.DTO.UserDtos.CreateUserDto;
import com.example.java_sr_29m.DTO.UserDtos.UpdateUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    List<User> getUsers();
    String addUser(CreateUserDto createUserDto);
    String updateUser(UpdateUserDto updateUserDto);
    String deleteUserById(Long id);
}
