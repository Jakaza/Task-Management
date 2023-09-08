package com.onrender.themba.taskmanagement.repository;

import com.onrender.themba.taskmanagement.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository  extends JpaRepository<TaskEntity, Long> {
}
