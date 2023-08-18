package taskmanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    private List<Task> Tasks = new ArrayList<>();

    @Override
    public void addTask(String taskText) {
        Task newTask = new Task(taskText);
        Tasks.add(newTask);
    }

    public void markAsDone(int taskIndex) {
        Tasks.get(taskIndex).markAsDone();
    }

    @Override
    public void displayTasks() {
        int index = 1;
        System.out.println("\n-----------------------------------");
        for (Task task : Tasks) {
            System.out.println(index + ". " + task.getDescription());
            index++;
        }
        System.out.println("-----------------------------------\n");
    }

    @Override
    public void updateTask(int selectedTask, String newDescription) {
        if (selectedTask < 0 || selectedTask > Tasks.size()) {
            System.out.println("Selected Index out of range");
        } else {
            Tasks.get(selectedTask).setTaskText(newDescription);
        }
    }

    @Override
    public void deleteTask(int selectedTask) {
        if (selectedTask < 0 || selectedTask > Tasks.size()) {
            System.out.println("Selected Index out of range");
        } else {
            Tasks.remove(selectedTask);
        }
    }

    // ADD LIST INTO A CSV FILE
    public void RecordTasks() {
        try (FileWriter TaskWriter = new FileWriter("Tasks.csv")) {
            TaskWriter.write("Description, Status\n");
            for (Task task : Tasks) {
                String taskStatus;
                if (task.getTaskStatus() == true) {
                    taskStatus = "Done";
                } else {
                    taskStatus = "Not Done";
                }
                TaskWriter.write(task.getDescription() + "," + taskStatus + "\n");

            }
        } catch (IOException e) {
            System.out.println("Error, File Not Found!");
        }
    }

    // EMPTY THE CSV FILE
    public void ClearRecord() {
        try (FileWriter TaskWriter = new FileWriter("Tasks.csv", false)) {
            for (int i = 0; i < Tasks.size(); i++) {
                TaskWriter.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error Clearing Files");
        }
    }

    // ADD FROM CSV TO LIST
    public void CSVtoList() {
        try (BufferedReader TasksReader = new BufferedReader(new FileReader("Tasks.csv"))) {
            String Line;
            TasksReader.readLine();
            while ((Line = TasksReader.readLine()) != null) {
                String[] Part = Line.split(",");
                if (Part.length == 2) {
                    String description = Part[0].trim();
                    String status = Part[1].trim();

                    Task task = new Task(description);
                    if (status == "Done") {
                        task.markAsDone();
                    } else {
                        task.setTaskIsDone(false);
                    }
                    Tasks.add(task);
                }
            }
            System.out.println("Task Read for CSV File is Successful");
        } catch (IOException e) {
            System.out.println("Error Reading from CSV to List");
        }
    }
}
