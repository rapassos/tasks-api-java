package com.rapassos.tasksapi.dto;

import com.rapassos.tasksapi.model.Task;

public record TaskResponseDTO(
        Long id,
        String title,
        String description,
        boolean completed
) {
    // Factory method elegante para converter a entidade em DTO sem reflexão imunda
    public static TaskResponseDTO fromEntity(Task task) {
        return new TaskResponseDTO(task.getId(), task.getTitle(), task.getDescription(), task.isCompleted());
    }
}
