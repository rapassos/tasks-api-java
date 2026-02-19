package com.rapassos.tasksapi.service;

import com.rapassos.tasksapi.dto.TaskRequestDTO;
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

    @Mock // Cria um simulacro do repositório
    private TaskRepository taskRepository;

    @InjectMocks // Injeta o mock acima dentro do serviço
    private TaskService taskService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks antes de cada teste
    }

    @Test
    @DisplayName("Deve salvar uma tarefa com sucesso")
    void saveTask_Success() {
        // Arrange (Configuração)
        TaskRequestDTO dto = new TaskRequestDTO("Estudar Java", "Finalizar testes unitários", false);
        Task task = new Task();
        task.setTitle(dto.title());

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        // Act (Ação)
        Task result = taskService.save(dto);

        // Assert (Verificação)
        assertNotNull(result);
        assertEquals("Estudar Java", result.getTitle());
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    @DisplayName("Deve retornar vazio ao tentar atualizar tarefa inexistente")
    void updateTask_NotFound() {
        // Arrange
        Long id = 1L;
        TaskRequestDTO dto = new TaskRequestDTO("Novo Titulo", "Desc", true);
        when(taskRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<Task> result = taskService.update(id, dto);

        // Assert
        assertTrue(result.isEmpty());
        verify(taskRepository, never()).save(any());
    }
}