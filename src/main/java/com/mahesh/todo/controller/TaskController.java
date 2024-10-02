package com.mahesh.todo.controller;

import com.mahesh.todo.model.Task;
import com.mahesh.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public void createTask(@RequestBody Task task) {
        taskService.createTask(task);
    }

    @GetMapping
    public List<Task> listTasks() {
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable String id, @RequestBody Task task) {
        taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
    }
}
