package com.todo.todoapp.Services;

import com.todo.todoapp.DTOs.TaskResponseDTO;
import com.todo.todoapp.Exceptions.DescriptionNotCorrectException;
import com.todo.todoapp.Exceptions.NameNotCorrect;
import com.todo.todoapp.Exceptions.StatusNotFoundException;
import com.todo.todoapp.Exceptions.TaskNotFoundException;
import com.todo.todoapp.Models.TaskStatus;
import com.todo.todoapp.Models.ToDoTask;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@Service
public class ToDoServices {

    private int id=0;

    List<TaskResponseDTO> tasks= new ArrayList<TaskResponseDTO>();
    public ResponseEntity<List<TaskResponseDTO>> listAllTasks(){
        return ok(tasks);
    }

    public ResponseEntity<TaskResponseDTO> getTaskByID(int id){
        for(TaskResponseDTO task:tasks){
            if(task.getTaskID()==id){
                return ok(task);
            }
        }
        return (ResponseEntity<TaskResponseDTO>) ResponseEntity.badRequest();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ToDoTask> createTask(String taskName, String taskDescription, TaskStatus taskStatus) throws NameNotCorrect, StatusNotFoundException, DescriptionNotCorrectException {
        ToDoTask task= new ToDoTask();
        task.setTaskID(++id);
        task.setTaskDescription(taskDescription);
        task.setTaskName(taskName);;
        task.setTaskStatus(taskStatus);

        tasks.add(task.build());
        return ResponseEntity.ok(task);
    }

    public ResponseEntity<TaskResponseDTO> updateTaskByID(int id,TaskStatus status) throws TaskNotFoundException{

        for(TaskResponseDTO task: tasks){
            if(task.getTaskID()==id){
                task.setTaskStatus(status);
                ResponseEntity.ok(task);
            }
        }
        return (ResponseEntity<TaskResponseDTO>) ResponseEntity.badRequest();
    }

    public ResponseEntity<TaskResponseDTO> deleteTaskbyID(int id) throws TaskNotFoundException{
        for(TaskResponseDTO task:tasks){
            if(task.getTaskID()==id) {
                TaskResponseDTO removed = task;
                tasks.remove(task);
                return ResponseEntity.ok(removed);
            }
        }
        return (ResponseEntity<TaskResponseDTO>) ResponseEntity.badRequest();
    }


    public ResponseEntity<TaskResponseDTO> deleteAllTasks() {
        tasks.clear();
        return (ResponseEntity<TaskResponseDTO>) ResponseEntity.ok();
    }
}
