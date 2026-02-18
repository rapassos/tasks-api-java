package com.rapassos.tasks_api_java.dto;

import jakarta.validation.constraints.NotBlank;

public record TaskRequestDTO(
        @NotBlank(message = "O título não pode estar em branco")
        String title,

        String description,

        boolean completed
) {}