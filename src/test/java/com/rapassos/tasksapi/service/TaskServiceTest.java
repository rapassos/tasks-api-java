package com.rapassos.tasksapi.service;

import com.rapassos.tasksapi.dto.TaskRequestDTO;
import com.rapassos.tasksapi.dto.TaskResponseDTO;
import com.rapassos.tasksapi.exception.ResourceNotFoundException;
import com.rapassos.tasksapi.model.Task;
import com.rapassos.tasksapi.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Deve salvar uma tarefa com sucesso")
    void saveTask_Success() {
        TaskRequestDTO dto = new TaskRequestDTO("Estudar Java", "Finalizar testes unitários", false);
        
        // Ajustado para usar setters convencionais/Lombok em vez do construtor cheio
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Estudar Java");
        task.setDescription("Finalizar testes unitários");
        task.setCompleted(false);

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        TaskResponseDTO result = taskService.save(dto);

        assertNotNull(result);
        assertEquals(1L, result.id());
        assertEquals("Estudar Java", result.title());
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    @DisplayName("Deve lançar ResourceNotFoundException ao tentar atualizar tarefa inexistente")
    void updateTask_NotFound() {
        Long id = 999L;
        TaskRequestDTO dto = new TaskRequestDTO("Novo Titulo", "Desc", true);
        when(taskRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> taskService.update(id, dto));
        verify(taskRepository, never()).save(any());
    }
}