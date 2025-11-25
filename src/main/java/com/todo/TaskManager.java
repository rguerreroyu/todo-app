package com.todo;

import java.util.*;
public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    public void addTask(Task task) {
        tasks.add(task);
    }
    public List<Task> getAllTasks() {
        return tasks;
    }
    public boolean markTaskDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setDone(true);
            return true;
        }
        return false;
    }
    public boolean deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            return true;
        }
        return false;
    }
}
