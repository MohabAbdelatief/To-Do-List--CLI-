package taskmanagement;
public class Task {
    // ATTRIBUTES
    private String Description;
    private Boolean TaskIsDone;

    // CONSTRUCTOR

    public Task(String Description) {
        this.Description = Description;
        TaskIsDone = false;
    }

    // SETTERS & GETTERS
    public void setTaskText(String taskText) {
        Description = taskText;
    }
    public void setTaskIsDone(Boolean taskIsDone) {
        TaskIsDone = taskIsDone;
    }

    public void markAsDone() {
        TaskIsDone = true;
    }

    public String getDescription() {
        return Description;
    }
    public Boolean getTaskStatus() {
        return TaskIsDone;
    }
}
