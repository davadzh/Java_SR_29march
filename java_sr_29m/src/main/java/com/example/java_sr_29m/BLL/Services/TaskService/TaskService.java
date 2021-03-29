package com.example.java_sr_29m.BLL.Services.TaskService;

import com.example.java_sr_29m.DAL.Entities.Task;
import com.example.java_sr_29m.DAL.Repositories.TaskRepo;
import com.example.java_sr_29m.DTO.TaskDtos.CreateTaskDto;
import com.example.java_sr_29m.DTO.TaskDtos.UpdateTaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public List<Task> getTasks() {
        return taskRepo.findAll();
    }

    @Override
    public String addTask(CreateTaskDto createTaskDto) {
        Task newTask = new Task(createTaskDto);
        taskRepo.save(newTask);

        return "Новое задание успешно создано";
    }

    @Override
    public String updateTask(UpdateTaskDto updateTaskDto) {
        Optional<Task> candidate = taskRepo.findById(updateTaskDto.id);

        if (candidate.isEmpty())
            throw new RuntimeException();

        Task task = candidate.get();
        task.setName(updateTaskDto.name);
        task.setDescription(updateTaskDto.description);
        task.setCompletionDate(updateTaskDto.completionDate);
        task.setUser(updateTaskDto.user);
        task.setCategories(updateTaskDto.categories);
        task.setModifyDate(new Date());

        taskRepo.save(task);
        return "Задание успешно обновлено";
    }

    @Override
    public String deleteTaskById(Long id) {
        var candidate = taskRepo.findById(id);

        if (candidate.isEmpty())
            return "Задания с таким id не существует";

        taskRepo.deleteById(id);

        return "Задание успешно удалено";
    }
}
