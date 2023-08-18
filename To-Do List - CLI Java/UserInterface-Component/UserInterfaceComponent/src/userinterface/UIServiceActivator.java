package userinterface;

import java.util.Scanner;

public class UIServiceActivator {

    UserInterfaceServiceImpl userInterfaceService = new UserInterfaceServiceImpl();

    public void Start() {
        Boolean AppIsActive = true;
        try (Scanner scanner = new Scanner(System.in)) {
            while (AppIsActive) {
                System.out.println("1. Add Task");
                System.out.println("2. Update Task Description");
                System.out.println("3. Delete Task");
                System.out.println("4. Mark Task as Done");
                System.out.println("5. Display Tasks");
                System.out.println("6. Quit");

                System.out.print("\nENTER YOUR CHOICE:");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        userInterfaceService.taskService.ClearRecord();
                        userInterfaceService.addTask();
                        userInterfaceService.taskService.RecordTasks();
                        break;
                    case 2:
                        userInterfaceService.updateTaskDescription();
                        userInterfaceService.taskService.ClearRecord();
                        userInterfaceService.taskService.RecordTasks();
                        break;
                    case 3:
                        userInterfaceService.deleteTask();
                        userInterfaceService.taskService.ClearRecord();
                        userInterfaceService.taskService.RecordTasks();
                        break;
                    case 4:
                        userInterfaceService.markAsDone();
                        userInterfaceService.taskService.ClearRecord();
                        userInterfaceService.taskService.RecordTasks();
                        break;
                    case 5:
                        userInterfaceService.taskService.CSVtoList();
                        userInterfaceService.taskService.displayTasks();
                        break;
                    case 6:
                        AppIsActive = false;
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
            }
        }
    }

    public void Stop() {

    }
}
