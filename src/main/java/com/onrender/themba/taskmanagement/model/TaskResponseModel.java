package com.onrender.themba.taskmanagement.model;

import com.onrender.themba.taskmanagement.entity.TaskEntity;

import java.util.ArrayList;
import java.util.List;

public class TaskResponseModel {
    private String message;
    private int totalPage;
    private int currentPage;
    private Long totalIntem;
    private List<TaskEntity> tasks = new ArrayList<>();

    public TaskResponseModel() {
    }

    public TaskResponseModel(String message, int totalPage, int currentPage, List<TaskEntity> tasks) {
        this.message = message;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.tasks = tasks;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Long getTotalIntem() {
        return totalIntem;
    }

    public void setTotalIntem(Long totalIntem) {
        this.totalIntem = totalIntem;
    }

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }
}
