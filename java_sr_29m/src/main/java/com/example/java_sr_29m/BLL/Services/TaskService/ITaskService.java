package com.example.java_sr_29m.BLL.Services.TaskService;

import com.example.java_sr_29m.DAL.Entities.Task;
import com.example.java_sr_29m.DAL.Entities.User;
import com.example.java_sr_29m.DTO.TaskDtos.CreateTaskDto;
import com.example.java_sr_29m.DTO.TaskDtos.UpdateTaskDto;
import com.example.java_sr_29m.DTO.UserDtos.CreateUserDto;
import com.example.java_sr_29m.DTO.UserDtos.UpdateUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITaskService {
    List<Task> getTasks();
    String addTask(CreateTaskDto createTaskDto);
    String updateTask(UpdateTaskDto updateTaskDto);
    String deleteTaskById(Long id);
}
