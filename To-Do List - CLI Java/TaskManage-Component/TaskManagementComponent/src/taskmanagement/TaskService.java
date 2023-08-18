package taskmanagement;
public interface TaskService {
    /*THIS INTERFACE REPRESENTS ALL FUNCTIONS THAT WILL BE USED TO DO CRUD OPERATIONS AND MORE FOR THE TASKS */

    void addTask(String taskText);
    void updateTask(int selectedTask, String newDescription);
    void deleteTask(int selectedTask);
    void markAsDone(int TaskIndex);
    void displayTasks();
}
