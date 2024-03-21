package com.github.lksferreira.apiresttodotask.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.lksferreira.apiresttodotask.model.TaskModel;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {

}
