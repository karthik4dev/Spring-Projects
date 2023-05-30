package com.todo.todoapp.Exceptions;

public class TaskNotFoundException extends Exception{
    public TaskNotFoundException(String message){
        super(message);
    }
}
