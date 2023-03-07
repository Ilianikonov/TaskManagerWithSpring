package com.example.demo;

import java.util.Objects;

public abstract class AbstractTask {
    private final int id;
    private String name;
    private String descriptions;
    private Status status;

    public AbstractTask(int id, String name, String descriptions, Status status) {
        this.id = id;
        this.name = name;
        this.descriptions = descriptions;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractTask that)) return false;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(descriptions, that.descriptions) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, descriptions, status);
    }

}
