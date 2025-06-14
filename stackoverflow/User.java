package stackoverflow;

import java.util.*;

public class User {
    private final int id;
    private final String username;
    private final String email;
    private int reputation;
    private final List<Question> questions;
    private final List<Answer> answers;
    private final List<Comment> comments;

    public User(String username, String email ) {
        this.id = generateId();
        this.username = username;
        this.email = email;
        this.reputation = 0;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public synchronized Question askQuestion(String title, String content, List<String> tags) {
        Question question = new Question(title, content, this, tags);
        this.questions.add(question);
        updateReputation(5);
        return question;
    }

    public synchronized Comment addComment(Commentable commentable, String content) {
        Comment comment = new Comment(content, this);
        this.comments.add(comment);
        commentable.addComment(comment);
        updateReputation(10);
        return comment;
    }

    public synchronized Answer answerQuestion(Question question, String content) {
        Answer answer = new Answer(content, this, question);
        this.answers.add(answer);
        question.addAnswer(answer);
        updateReputation(10);
        return answer;
    }


    public synchronized void updateReputation(int value) {
        this.reputation += value;
        if (this.reputation < 0) {
            this.reputation = 0;
        }
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getReputation() {
        return reputation;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
