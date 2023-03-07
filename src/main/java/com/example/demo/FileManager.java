package com.example.demo;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;

@Service
@ConditionalOnProperty(name = "application.manager.type", havingValue = "FileManager")
public class FileManager extends Manager {

    public Task toTask(String line) {
        String[] arrayline = line.split("////");
        int id = Integer.parseInt(arrayline[0]);
        Status status = Status.NEW;
        if (arrayline[3].equals("DONE")) {
            status = Status.DONE;
        } else if (arrayline[3].equals("IN_PROGRESS")) {
            status = Status.IN_PROGRESS;
        }
        return new Task(id, arrayline[1], arrayline[2], status);
    }
    public Epic toEpic(String line){
        String[] arrayline = line.split("////");
        int id = Integer.parseInt(arrayline[0]);
        Status status = Status.NEW;
        if (arrayline[3].equals("DONE")){
            status = Status.DONE;
        } else if (arrayline[3].equals("IN_PROGRESS")){
            status = Status.IN_PROGRESS;
        }
        return new Epic(id, arrayline[1], arrayline[2], status);
    }
    public Subtask toSubtask(String line){
        String[] arrayline = line.split("////");
        int epicId = Integer.parseInt(arrayline[0]);
        int id = Integer.parseInt(arrayline[1]);
        Status status = Status.NEW;
        if (arrayline[4].equals("DONE")){
            status = Status.DONE;
        } else if (arrayline[4].equals("IN_PROGRESS")){
            status = Status.IN_PROGRESS;
        }
        return new Subtask(epicId, id, arrayline[2], arrayline[3], status);
    }
    @Override
    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("taskFile"))){
            String line;
            while ((line = reader.readLine()) != null){
                list.add(toTask(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public ArrayList<Epic> getAllEpic() {
            ArrayList<Epic> list = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("epicFile"))){
                String line;
                while ((line = reader.readLine()) != null){
                    list.add(toEpic(line));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return list;
    }

    @Override
    public ArrayList<Subtask> getAllSubtask() {
        ArrayList<Subtask> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("subtaskFile"))){
            String line;
            while ((line = reader.readLine()) != null){
                list.add(toSubtask(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void deleteAllTasks() {
        File file = new File("taskFile");
        file.delete();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("taskFile", true))) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAllEpic() {
        File file = new File("epicFile");
        file.delete();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("epicFile", true))) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAllSubtask() {
        File file = new File("subtaskFile");
        file.delete();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("subtaskFile", true))) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Task getTaskById(int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("taskFile"))){
            String line;
            while ((line = reader.readLine()) != null){
                if (toTask(line).getId() == id){
                    return toTask(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Epic getEpicById(int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("epicFile"))){
            String line;
            while ((line = reader.readLine()) != null){
                if (toTask(line).getId() == id){
                    return toEpic(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Subtask getSubtaskById(int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("subtaskFile"))){
            String line;
            while ((line = reader.readLine()) != null){
                if (toSubtask(line).getId() == id){
                    return toSubtask(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void deleteTaskById(int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("taskFile"))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("taskFile.buffer"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (toTask(line).getId() != id){
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File file = new File("taskFile");
        file.delete();
        File taskFile = new File("taskFile");
        File taskFileBuffer = new File("taskFile.buffer");
        taskFileBuffer.renameTo(taskFile);
    }

    @Override
    public void deleteEpicById(int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("epicFile"))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("epicFile.buffer"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (toEpic(line).getId() != id){
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File file = new File("epicFile");
        file.delete();
        File taskFile = new File("epicFile");
        File taskFileBuffer = new File("epicFile.buffer");
        taskFileBuffer.renameTo(taskFile);
    }

    @Override
    public void deleteSubtaskById(int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("subtaskFile"))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("subtaskFile.buffer"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (toSubtask(line).getId() != id){
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File file = new File("subtaskFile");
        file.delete();
        File taskFile = new File("subtaskFile");
        File taskFileBuffer = new File("subtaskFile.buffer");
        taskFileBuffer.renameTo(taskFile);
    }

    @Override
    public void addTask(Task task) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("taskFile", true))) {
            if (getTaskById(task.getId()) == null) {
                writer.write(task.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addEpic(Epic task) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("epicFile", true))) {
            if (getEpicById(task.getId()) == null) {
                writer.write(task.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addSubtask(Subtask task) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("subtaskFile", true))) {
            if (getSubtaskById(task.getId()) == null) {
                writer.write(task.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTheEpic(Epic task) {
        try (BufferedReader reader = new BufferedReader(new FileReader("epicFile"))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("epicFile.buffer"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (toEpic(line).getId() != task.getId()){
                        writer.write(line);
                        writer.newLine();
                    } else {
                        writer.write(task.toString());
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File file = new File("epicFile");
        file.delete();
        File taskFile = new File("epicFile");
        File taskFileBuffer = new File("epicFile.buffer");
        taskFileBuffer.renameTo(taskFile);
    }

    @Override
    public void updateTheSubtask(Subtask task) {
        try (BufferedReader reader = new BufferedReader(new FileReader("subtaskFile"))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("subtaskFile.buffer"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (toSubtask(line).getId() != task.getId()){
                        writer.write(line);
                        writer.newLine();
                    } else {
                        writer.write(task.toString());
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File file = new File("subtaskFile");
        file.delete();
        File taskFile = new File("subtaskFile");
        File taskFileBuffer = new File("subtaskFile.buffer");
        taskFileBuffer.renameTo(taskFile);
    }

    @Override
    public void updateTheTask(Task task) {
        try (BufferedReader reader = new BufferedReader(new FileReader("taskFile"))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("taskFile.buffer"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (toTask(line).getId() != task.getId()){
                        writer.write(line);
                        writer.newLine();
                    } else {
                        writer.write(task.toString());
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File file = new File("taskFile");
        file.delete();
        File taskFile = new File("taskFile");
        File taskFileBuffer = new File("taskFile.buffer");
        taskFileBuffer.renameTo(taskFile);
    }

    @Override
    public ArrayList<Subtask> getListAllSubtaskBelongingToEpic(Epic epic) {
        ArrayList<Subtask> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("subtaskFile"))){
            String line;
            while ((line = reader.readLine()) != null){
                if (toSubtask(line).getEpicId() == epic.getId()) {
                    list.add(toSubtask(line));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
