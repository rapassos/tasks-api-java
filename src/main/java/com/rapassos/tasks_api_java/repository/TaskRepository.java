package com.rapassos.tasks_api_java.repository;

import com.rapassos.tasks_api_java.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // O JpaRepository já fornece métodos como findById, save, deleteById e findAll.
}