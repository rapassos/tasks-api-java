package com.rapassos.tasksapi.repository;

import com.rapassos.tasksapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // O JpaRepository já fornece métodos como findById, save, deleteById e findAll.
}