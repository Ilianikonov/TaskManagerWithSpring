package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TaskManagerController {
    private final Manager manager;
    public TaskManagerController(@Autowired Manager manager) {
        this.manager = manager;
    }
    @GetMapping("/get/task")
    public ArrayList<Task> getTask(){
        return manager.getAllTasks();
    }
}
