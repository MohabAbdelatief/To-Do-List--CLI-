package userinterface;

import taskmanagement.*;
import java.util.Scanner;

public class UserInterfaceServiceImpl implements UserInterfaceService {

    TaskServiceImpl taskService = new TaskServiceImpl();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void addTask() {
        System.out.print("Enter Task Description: ");
        String Description = scanner.nextLine();
        taskService.addTask(Description);
        System.out.println("\nTask Added\n");
    }

    @Override
    public void updateTaskDescription() {
        System.out.println("Enter task number you want to update: ");
        int index = scanner.nextInt();
        System.out.println("Enter the new task Description");
        String newDescription = scanner.nextLine();
        taskService.updateTask(index, newDescription);
        System.out.println("\nTask " + index + " has been Updated!\n");
    }

    @Override
    public void deleteTask() {
        System.out.println("Enter task number to delete: ");
        int taskIndex = scanner.nextInt();
        taskService.deleteTask(taskIndex - 1);
        System.out.println("\nTask " + taskIndex + " Has been deleted.\n");
    }

    @Override
    public void markAsDone() {
        System.out.println("Enter task number to Mark as Done: ");
        int index = scanner.nextInt();
        taskService.markAsDone(index - 1);
        System.out.println("\nTask " + index + " has been marked as done!\n");
    }

}
