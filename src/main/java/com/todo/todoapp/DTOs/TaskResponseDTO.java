package com.todo.todoapp.DTOs;

import com.todo.todoapp.Exceptions.DescriptionNotCorrectException;
import com.todo.todoapp.Exceptions.NameNotCorrect;
import com.todo.todoapp.Exceptions.StatusNotFoundException;
import com.todo.todoapp.Models.TaskStatus;
import org.springframework.scheduling.config.Task;

import java.util.EnumSet;

public class TaskResponseDTO {
    private String taskName;
    private int taskID;
    private String taskDescription;
    private TaskStatus taskStatus;

    public int getTaskID(){
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



    private TaskResponseDTO(Builder builder) {
        this.taskID= builder.taskID;
        this.taskName= builder.taskName;
        this.taskDescription=builder.taskDescription;
        this.taskStatus=builder.taskStatus;
    }

    public static Builder builder(){
        Builder b = new Builder();
        return b;
    }

    public static class Builder{
        int taskID;

        public Builder getTaskID() {
            return this;
        }

        public Builder setTaskID(int taskID) {
            this.taskID = taskID;
            return this;
        }

        String taskName;
        String taskDescription;
         TaskStatus taskStatus;
        EnumSet<TaskStatus> status=EnumSet.allOf(TaskStatus.class);
        public Builder getTaskName() {
            return this;
        }

        public Builder setTaskName(String taskName) {
            this.taskName = taskName;
            return this;
        }

        public Builder getTaskDescription() {
            return this;
        }

        public Builder setTaskDescription(String taskDescription) {
            this.taskDescription = taskDescription;
            return this;
        }

        public Builder getTaskStatus() {
            return this;

        }

        public Builder setTaskStatus(TaskStatus taskStatus) {
            this.taskStatus = taskStatus;
            return this;
        }
        public TaskResponseDTO build() throws NameNotCorrect, DescriptionNotCorrectException, StatusNotFoundException {
            if(taskName.length()<1 && taskName.length()>50){
                throw new NameNotCorrect("Name should be more than 0 and less than 50");
            }
            if(taskDescription.length()<1 && taskDescription.length()>200){
                throw new DescriptionNotCorrectException("Description should be more than 0 and less than 200");
            }
            if(!status.contains(taskStatus)){
                throw new StatusNotFoundException("Status is not found in the list");
            }
             return new TaskResponseDTO(this);
        }
    }

}
