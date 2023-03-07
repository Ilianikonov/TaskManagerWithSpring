package com.example.demo;

import java.util.ArrayList;

public abstract class Manager {

    private final TaskFactory taskFactory;

    public Manager() {
        taskFactory = new TaskFactory(this);
    }

    public TaskFactory getTaskFactory() {
        return taskFactory;
    }

    public abstract ArrayList<Task> getAllTasks();
    public abstract ArrayList<Epic> getAllEpic();
    public abstract ArrayList<Subtask> getAllSubtask();
    public abstract void deleteAllTasks();
    public abstract void deleteAllEpic();
    public abstract void deleteAllSubtask();
    public abstract Task getTaskById(int id);
    public abstract Epic getEpicById(int id);
    public abstract Subtask getSubtaskById(int id);
    public abstract void deleteTaskById(int id);
    public abstract void deleteEpicById(int id);
    public abstract void deleteSubtaskById(int id);
    public abstract void addTask(Task task);
    public abstract void addEpic(Epic task);
    public abstract void addSubtask(Subtask task);
    public abstract void updateTheEpic(Epic task);
    public abstract void updateTheSubtask(Subtask task);
    public abstract void updateTheTask(Task task);
    public abstract ArrayList<Subtask> getListAllSubtaskBelongingToEpic(Epic epic);
}
