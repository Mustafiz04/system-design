package taskmanagersystem;

import java.util.*;

public class Task {
    private final String id;
    private String title;
    private String description;
    private TASK_PRIORITY priority;
    private TASK_STATUS status;
    private User assignee;
    private User reporter;
    private final Date createdAt;
    private Date dueDate;
    private Date completedAt;
    private List<Comment> comments;

    public Task(String title, String description, TASK_PRIORITY priority, User reporter, User assignee, Date dueDate) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status =TASK_STATUS.BACKLOG;
        this.assignee = assignee;
        this.reporter = reporter;
        this.createdAt = new Date();
        this.dueDate = dueDate;
        this.completedAt = null;
        this.comments = new ArrayList<>();
    }



    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TASK_PRIORITY getPriority() {
        return priority;
    }

    public void setPriority(TASK_PRIORITY priority) {
        this.priority = priority;
    }

    public TASK_STATUS getStatus() {
        return status;
    }

    public void setStatus(TASK_STATUS status) {
        this.status = status;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(Comment comments) {
        this.comments.add(comments);
    }
}
