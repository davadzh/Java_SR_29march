package com.example.java_sr_29m.DTO.UserDtos;

import com.example.java_sr_29m.DAL.Entities.Task;

import java.util.Date;
import java.util.List;

public class UpdateUserDto {
    public Long id;
    public String username;
    public String lastname;
    public String firstname;
    public String patronymic;
    public Date birthDate;

    public List<Task> tasks;
}
