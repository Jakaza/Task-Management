package com.onrender.themba.taskmanagement.model;

public class TaskResponseModel {
    private String message;
    private Long id;
    private String title;
    private String description;

    public TaskResponseModel(String message, Long id, String title, String description) {
        this.message = message;
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
