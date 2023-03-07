package com.example.demo;

import java.util.Objects;

public class Subtask extends AbstractTask {
    private int epicId;
    public Subtask(int epicId, int id, String name, String descriptions, Status status) {
        super(id, name, descriptions, status);
        this.epicId = epicId;
    }

//    @Override
//    public String toString() {
//        return "Subtask{" +
//                "epicId=" + epicId +
//                "} " + super.toString();
//    }

        @Override
    public String toString() {
        return this.epicId + "////" + this.getId() + "////" + this.getName() + "////" + this.getDescriptions() + "////" + this.getStatus();
    }
    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subtask subtask)) return false;
        if (!super.equals(o)) return false;
        return epicId == subtask.epicId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), epicId);
    }
}
