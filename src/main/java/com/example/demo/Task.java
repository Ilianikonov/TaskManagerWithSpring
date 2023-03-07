package com.example.demo;

public class Task extends AbstractTask {
    public Task(int id, String name, String descriptions, Status status) {
        super(id,name,descriptions,status);
    }

        @Override
    public String toString() {
        return this.getId() + "////" + this.getName() + "////" + this.getDescriptions() + "////" + this.getStatus();
    }

}
