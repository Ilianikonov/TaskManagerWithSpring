package com.example.demo;


import org.springframework.stereotype.Service;

@Service
public class TaskFactory {
    private final Manager manager;

    public TaskFactory( Manager manager) {
        this.manager = manager;
    }

    public Subtask createSubtask (int epicID, int id, String name, String description, Status status){
        if (manager.getEpicById(epicID) == null) {
            throw new RuntimeException("такого epicId не существует!");
        }
        Subtask subtask = new Subtask(epicID, id, name, description, status);
        manager.addSubtask(subtask);
        return subtask;
    }

    public Task createTask (int id, String name, String description, Status status){
        Task task = new Task(id, name, description, status);
        manager.addTask(task);
        return new Task(id, name, description, status);
    }

    public Epic createEpic (int id, String name, String description, Status status){
        Epic epic = new Epic(id, name, description, status);
        manager.addEpic(epic);
        return new Epic(id, name, description, status);

    }
}
