package com.rapassos.tasksapi.service;

import com.rapassos.tasksapi.dto.TaskRequestDTO;
import com.rapassos.tasksapi.dto.TaskResponseDTO;
import com.rapassos.tasksapi.exception.ResourceNotFoundException;
import com.rapassos.tasksapi.model.Task;
import com.rapassos.tasksapi.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = true)
    public List<TaskResponseDTO> findAll() {
        return taskRepository.findAll().stream()
                .map(TaskResponseDTO::fromEntity)
                .toList();
    }

    @Transactional(readOnly = true)
    public TaskResponseDTO findById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa com ID " + id + " não encontrada."));
        return TaskResponseDTO.fromEntity(task);
    }

    @Transactional
    public TaskResponseDTO save(TaskRequestDTO data) {
        Task task = new Task();
        task.setTitle(data.title());
        task.setDescription(data.description());
        task.setCompleted(data.completed());
        
        Task savedTask = taskRepository.save(task);
        return TaskResponseDTO.fromEntity(savedTask);
    }

    @Transactional
    public TaskResponseDTO update(Long id, TaskRequestDTO data) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Impossível atualizar. Tarefa com ID " + id + " não encontrada."));
        
        task.setTitle(data.title());
        task.setDescription(data.description());
        task.setCompleted(data.completed());
        
        Task updatedTask = taskRepository.save(task);
        return TaskResponseDTO.fromEntity(updatedTask);
    }

    @Transactional
    public void delete(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Impossível deletar. Tarefa com ID " + id + " não encontrada.");
        }
        taskRepository.deleteById(id);
    }
}