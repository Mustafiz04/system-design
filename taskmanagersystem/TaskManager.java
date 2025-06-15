package taskmanagersystem;

import java.util.*;
public class TaskManager {
    private static TaskManager instance;
    private final Map<String, Task> tasks;

    public TaskManager() {
        this.tasks = new HashMap<>();
    }

    public static TaskManager getInstance() {
        if( instance == null ) {
            instance = new TaskManager();
        }
        return instance;
    }

    public Task createTask(User reporter, User assignee, String title, String description, TASK_PRIORITY priority, Date dueDate) {
        Task task = new Task(title, description, priority, reporter, assignee, dueDate);
        addTask(task);
        reporter.addReportTask(task);
        assignee.assignTask(task);
        return task;
    }

    public void updateTaskStatus(String taskId, TASK_STATUS status) {
        Task task = getTaskById(taskId);
        if (task != null) {
            task.setStatus(status);
            if (status == TASK_STATUS.COMPLETED) {
                task.setCompletedAt(new Date());
            }
        }
    }

    public void updateTaskPriority(String taskId, TASK_PRIORITY priority) {
        Task task = tasks.get(taskId);
        if( task != null ) {
            task.setPriority(priority);
        }
    }

    public void assignTask(String taskId, User assignee) {
        Task task = getTaskById(taskId);
        if (task != null) {
            User  oldAssignee = task.getAssignee();
            oldAssignee.removeAssignedTask(task);
            task.setAssignee(assignee);
            assignee.assignTask(task);
        }
    }

    public void addComment(String taskId, String content, User author) {
        Task task = getTaskById(taskId);
        if (task != null) {
            Comment comment = new Comment(content, author);
            task.setComments(comment);
        }
    }

    public List<Task> listTasksByUser(User user) {
        List<Task> userTasks = new ArrayList<>();
        for(Task task: tasks.values()) {
            if( task.getAssignee() != null && task.getAssignee().getId().equals(user.getId()) ||
                task.getReporter() != null && task.getReporter().getId().equals(user.getId())) {
                userTasks.add(task);
            }
        }
        return userTasks;
    }

    public List<Task> getTasksByStatus(TASK_STATUS status) {
        List<Task> filteredTasks = new ArrayList<>();
        for(Task task: tasks.values()) {
            if( task.getStatus() == status ) {
                filteredTasks.add(task);
            }
        }

        return filteredTasks;
    }

    public List<Task> searchTask(String keyword) {
        List<Task> filteredTask = new ArrayList<>();
        for(Task task: tasks.values()) {
            if( task.getTitle().contains(keyword) || task.getDescription().contains(keyword) ) {
                filteredTask.add(task);
            }
        }

        return filteredTask;
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public Task getTaskById(String taskId) {
        return tasks.get(taskId);
    }

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void removeTask(String taskId) {
        tasks.remove(taskId);
    }
}
