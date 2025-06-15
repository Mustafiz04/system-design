package taskmanagersystem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final String id;
    private String name;
    private final List<Task> assignedTasks;
    private final List<Task> reportedTasks;

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        assignedTasks = new ArrayList<>();
        reportedTasks = new ArrayList<>();
    }

    public void assignTask(Task task) {
        if (!assignedTasks.contains(task)) {
            assignedTasks.add(task);
        }
    }

    public void removeAssignedTask(Task task) {
        task.setAssignee(null);
        assignedTasks.remove(task);
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public void addReportTask(Task task) {
        if (!reportedTasks.contains(task)) {
            reportedTasks.add(task);
        }
    }

    public List<Task> getReportedTasks() {
        return reportedTasks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
