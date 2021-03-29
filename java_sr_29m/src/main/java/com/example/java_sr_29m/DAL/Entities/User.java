package com.example.java_sr_29m.DAL.Entities;

import com.example.java_sr_29m.DTO.UserDtos.CreateUserDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class User extends CoreEntity {
    private String username;
    private String lastname;
    private String firstname;
    private String patronymic;
    private Date birthDate;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;


    // Constructors

    public User(){}

    public User(CreateUserDto createUserDto) {
        super();
        this.username = createUserDto.username;
        this.lastname = createUserDto.lastname;
        this.firstname = createUserDto.firstname;
        this.patronymic = createUserDto.patronymic;
        this.birthDate = createUserDto.birthDate;
        this.tasks = createUserDto.tasks;
    }


    // Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
