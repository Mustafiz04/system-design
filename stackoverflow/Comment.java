package stackoverflow;

public class Comment {
    private final int id;
    private final String content;
    private final User author;
    private final long createdAt;

    public Comment(String content, User author ) {
        this.id = generateId();
        this.content = content;
        this.author = author;
        this.createdAt = System.currentTimeMillis();
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public long getCreatedAt() {
        return createdAt;
    }
}
