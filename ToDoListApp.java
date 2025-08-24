import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String description;
    boolean isCompleted;

    // Constructor
    Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    // Mark task as completed
    void markAsComplete() {
        this.isCompleted = true; 
    }

    @Override
    public String toString() {
        // Use Unicode for checkmark ✔ (\u2714) and empty box (\u25FB)
        return (isCompleted  ? "[completed] " : "[] ") + description;
    }
}

public class ToDoListApp {

    private static ArrayList<Task> tasks = new ArrayList<>();

    // Add new task
    public static void addTask(String description) {
        tasks.add(new Task(description));
        System.out.println("Task added successfully!");
    }

    // Delete task by index
    public static void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid task index!");
        }
    }

    // Display all tasks
    public static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("\n--- To-Do List ---");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }

    // Mark a task as completed
    public static void markTaskComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsComplete();
            System.out.println("Task marked as complete!");
        } else {
            System.out.println("Invalid task index!");
        }
    }

    // Main program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Mark Task as Complete");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine()); // safer input
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String desc = scanner.nextLine();
                    addTask(desc);
                    break;

                case 2:
                    displayTasks();
                    System.out.print("Enter task index to delete: ");
                    try {
                        int delIndex = Integer.parseInt(scanner.nextLine());
                        deleteTask(delIndex);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter a valid number.");
                    }
                    break;

                case 3:
                    displayTasks();
                    break;

                case 4:
                    displayTasks();
                    System.out.print("Enter task index to mark as complete: ");
                    try {
                        int compIndex = Integer.parseInt(scanner.nextLine());
                        markTaskComplete(compIndex);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter a valid number.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting To-Do List App. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again!");
            }
        }

        scanner.close();
    }
}
