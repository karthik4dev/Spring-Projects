package com.todo.todoapp;

import com.todo.todoapp.DTOs.TaskResponseDTO;
import com.todo.todoapp.Exceptions.DescriptionNotCorrectException;
import com.todo.todoapp.Exceptions.NameNotCorrect;
import com.todo.todoapp.Exceptions.StatusNotFoundException;
import com.todo.todoapp.Exceptions.TaskNotFoundException;
import com.todo.todoapp.Models.ToDoTask;
import com.todo.todoapp.Services.ToDoServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("")
public class ToDoController {
    private final ToDoServices toDoServices;
    ToDoController(ToDoServices toDoServices){
        this.toDoServices=toDoServices;
    }
    @GetMapping("")
    public ResponseEntity<List<TaskResponseDTO>> listAllTasks(){
        return toDoServices.listAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> listTaskById(@PathVariable("id") int id){
        return toDoServices.getTaskByID(id);
    }
    @PostMapping("")
    public ResponseEntity<ToDoTask> createTask(@RequestBody ToDoTask task) throws NameNotCorrect, StatusNotFoundException, DescriptionNotCorrectException {
        return toDoServices.createTask(task.getTaskName(), task.getTaskDescription(),task.getTaskStatus());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTaskByID(@PathVariable int id, @RequestBody TaskResponseDTO taskResponseDTO ) throws TaskNotFoundException {
        return toDoServices.updateTaskByID(id,taskResponseDTO.getTaskStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> deleteTaskByID(@PathVariable int id) throws TaskNotFoundException {
        return toDoServices.deleteTaskbyID(id);
    }

    @DeleteMapping("")
    public ResponseEntity<TaskResponseDTO> deleteAllTasks(){
        return toDoServices.deleteAllTasks();
    }
}
