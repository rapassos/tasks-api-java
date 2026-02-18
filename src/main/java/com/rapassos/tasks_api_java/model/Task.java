package com.rapassos.tasks_api_java.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private boolean completed = false;
}