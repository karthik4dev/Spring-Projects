package com.todo.todoapp.Models;

import com.todo.todoapp.DTOs.TaskResponseDTO;
import com.todo.todoapp.Exceptions.DescriptionNotCorrectException;
import com.todo.todoapp.Exceptions.NameNotCorrect;
import com.todo.todoapp.Exceptions.StatusNotFoundException;

public class ToDoTask {
    private int taskID;
    private String taskName;
    private String taskDescription;
    private TaskStatus taskStatus;

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public TaskResponseDTO build() throws NameNotCorrect, StatusNotFoundException, DescriptionNotCorrectException {
        TaskResponseDTO dto = TaskResponseDTO.builder().setTaskDescription(taskDescription).setTaskStatus(taskStatus).setTaskName(taskName).setTaskID(taskID).build();
        return dto;

    }
}
