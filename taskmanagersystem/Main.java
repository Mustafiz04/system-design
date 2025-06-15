package taskmanagersystem;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        TaskManager system = TaskManager.getInstance();

        User bob = new User("Bob");
        User alice = new User("Alice");
        User charlie = new User("Charlie");
        User dave = new User("Dave");

        Task task1 = system.createTask(bob, alice, "Task 1", "Description for Task 1", TASK_PRIORITY.P2, new Date());

        alice.getAssignedTasks().forEach(task -> {
            System.out.println("Alice's Assigned Task: " + task.getTitle());
        });

        system.assignTask(task1.getId(), charlie);
        System.out.println("After assigning Task 1 to Charlie:");

        for(Task task: system.getAllTasks()) {
            System.out.println("Task ID: " + task.getId());
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Priority: " + task.getPriority());
            System.out.println("Status: " + task.getStatus());
            System.out.println("Assignee: " + (task.getAssignee() != null ? task.getAssignee().getName() : "None"));
            System.out.println("Reporter: " + (task.getReporter() != null ? task.getReporter().getName() : "None"));
            System.out.println("Created At: " + task.getCreatedAt());
            System.out.println("Due Date: " + task.getDueDate());
            System.out.println("Completed At: " + task.getCompletedAt());
            System.out.println("-----------------------------");
        }
    }
}
