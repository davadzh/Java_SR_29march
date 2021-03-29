package com.example.java_sr_29m.Controllers;

import com.example.java_sr_29m.BLL.Services.TaskService.ITaskService;
import com.example.java_sr_29m.DAL.Entities.Task;
import com.example.java_sr_29m.DTO.TaskDtos.CreateTaskDto;
import com.example.java_sr_29m.DTO.TaskDtos.UpdateTaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/task")
public class TaskController {
    private final ITaskService taskService;

    @Autowired
    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/gettasks")
    public ResponseEntity<List<Task>> GetAllTasks() {
        List<Task> allTasks = taskService.getTasks();

        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }

    @PostMapping(value = "/createtask")
    public ResponseEntity<String> CreateTask(@RequestBody CreateTaskDto createTaskDto) {
        String message = taskService.addTask(createTaskDto);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletetaskbyid")
    public ResponseEntity<String> DeleteTaskById(@RequestBody Long id) {
        String message = taskService.deleteTaskById(id);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping(value = "/updatetask")
    public ResponseEntity<String> UpdateTask(@RequestBody UpdateTaskDto updateTaskDto) {
        String message = taskService.updateTask(updateTaskDto);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
