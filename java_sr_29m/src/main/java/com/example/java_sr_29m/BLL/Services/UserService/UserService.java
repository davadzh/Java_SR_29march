package com.example.java_sr_29m.BLL.Services.UserService;

import com.example.java_sr_29m.DAL.Entities.User;
import com.example.java_sr_29m.DAL.Repositories.UserRepo;
import com.example.java_sr_29m.DTO.UserDtos.CreateUserDto;
import com.example.java_sr_29m.DTO.UserDtos.UpdateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public String addUser(CreateUserDto createUserDto) {
        User newUser = new User(createUserDto);
        userRepo.save(newUser);

        return "Новый пользователь успешно создан";
    }

    @Override
    public String updateUser(UpdateUserDto updateUserDto) {
        Optional<User> candidate = userRepo.findById(updateUserDto.id);

        if (candidate.isEmpty())
            throw new RuntimeException();

        User user = candidate.get();
        user.setUsername(updateUserDto.username);
        user.setLastname(updateUserDto.lastname);
        user.setPatronymic(updateUserDto.patronymic);
        user.setBirthDate(updateUserDto.birthDate);
        user.setFirstname(updateUserDto.firstname);
        user.setTasks(updateUserDto.tasks);
        user.setModifyDate(new Date());

        userRepo.save(user);
        return "Пользователь успешно обновлен";
    }

    @Override
    public String deleteUserById(Long id) {
        var candidate = userRepo.findById(id);

        if (candidate.isEmpty())
            return "Пользователя с таким id не существует";

        userRepo.deleteById(id);

        return "Пользователь успешно удален";
    }
}
