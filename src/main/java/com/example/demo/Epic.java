package com.example.demo;

import java.util.ArrayList;
import java.util.Objects;

public class Epic extends AbstractTask {
    private final ArrayList<Subtask> subtasks = new ArrayList<>();

    public Epic(int id, String name, String descriptions, Status status) {
        super(id, name, descriptions, status);
    }
    public void addSubtaskEpic(Subtask subtask){
        subtasks.add(subtask);
    }
    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

//    @Override
//    public String toString() {
//        return "Epic{" +
//                "subtasks=" + subtasks +
//                "} " + super.toString();
//    }
        @Override
    public String toString() {
        return this.getId() + "////" + this.getName() + "////" + this.getDescriptions() + "////" + this.getStatus();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Epic epic)) return false;
        if (!super.equals(o)) return false;
        return subtasks.equals(epic.subtasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subtasks);
    }
}
