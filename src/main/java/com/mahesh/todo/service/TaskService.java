package com.mahesh.todo.service;

import com.mahesh.todo.model.Task;
import com.mahesh.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void createTask(@RequestBody Task task) {
        taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    public void updateTask(String id, Task updatedTask) {
        Optional<Task> existingTaskOptional = taskRepository.findById(id);
        if(existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
//            existingTask.setCompleted(updatedTask.getCompleted());
            taskRepository.save(existingTask);
        }
        else {
            throw new RuntimeException("Task not found");
        }
    }
}
