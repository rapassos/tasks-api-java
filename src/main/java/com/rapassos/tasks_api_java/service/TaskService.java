package com.rapassos.tasks_api_java.service;

import com.rapassos.tasks_api_java.dto.TaskRequestDTO;
import com.rapassos.tasks_api_java.model.Task;
import com.rapassos.tasks_api_java.repository.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Transactional
    public Task save(TaskRequestDTO data) {
        Task task = new Task();
        BeanUtils.copyProperties(data, task);
        return taskRepository.save(task);
    }

    @Transactional
    public Optional<Task> update(Long id, TaskRequestDTO data) {
        return taskRepository.findById(id).map(existingTask -> {
            BeanUtils.copyProperties(data, existingTask, "id"); // "id" é ignorado para não sobrescrever
            return taskRepository.save(existingTask);
        });
    }

    @Transactional
    public boolean delete(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}