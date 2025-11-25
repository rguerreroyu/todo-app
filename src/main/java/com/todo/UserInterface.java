package com.todo;
import java.util.Scanner;
public class UserInterface {
    private TaskManager manager = new TaskManager();
    private Scanner scanner = new Scanner(System.in);
    public void start() {
        while (true) {
            System.out.println("\n=== TO-DO LIST ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Done");
            System.out.println("4. Delete Task");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addTask();
                case 2 -> listTasks();
                case 3 -> completeTask();
                case 4 -> deleteTask();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
    private void addTask() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        manager.addTask(new Task(title, description));
        System.out.println("Task added!");
    }
    private void listTasks() {
        var tasks = manager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }
    private void completeTask() {
        listTasks();
        System.out.print("Enter task number to mark as done: ");
        int index = Integer.parseInt(scanner.nextLine());
        if (manager.markTaskDone(index))
            System.out.println("Marked as done.");
        else
            System.out.println("Invalid index.");
    }
    private void deleteTask() {
        listTasks();
        System.out.print("Enter task number to delete: ");
        int index = Integer.parseInt(scanner.nextLine());
        if (manager.deleteTask(index))
            System.out.println("Deleted.");
        else
            System.out.println("Invalid index.");
    }
}