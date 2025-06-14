package stackoverflow;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StackOverflow {
    private final Map<Integer, Question> question;
    private final Map<Integer, User> users;
    private final Map<Integer, Answer> answers;
    private final Map<String, Tag> tags;

    public StackOverflow() {
        this.question = new ConcurrentHashMap<>();
        this.users = new ConcurrentHashMap<>();
        this.answers = new ConcurrentHashMap<>();
        this.tags = new ConcurrentHashMap<>();
    }

    public User createUser(String username, String email) {
        User user = new User(username, email);
        users.put(user.getId(), user);
        return user;
    }

    public Question askQuestion(User user, String title, String content, List<String> tags) {
        Question question = user.askQuestion(title, content, tags);
        this.question.put(question.getId(), question);
        for(Tag tag: question.getTags()) {
            this.tags.putIfAbsent(tag.getName(), tag);
        }
        return question;
    }

    public Answer answerQuestion(User user, Question question, String content) {
        Answer answer = user.answerQuestion(question, content);
        this.answers.put(answer.getId(), answer);

        return answer;
    }

    public Comment addComment(User user, Commentable commentable, String content) {
        return user.addComment(commentable, content);
    }

    public void vote(User user, Votable votable, VoteType voteType) {
        votable.vote(user, voteType);
    }

    public void acceptAnswer(Answer answer) {
        answer.makeAccepted();
    }

    public Map<Integer, Question> getQuestion() {
        return question;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public Map<Integer, Answer> getAnswers() {
        return answers;
    }

    public Map<String, Tag> getTags() {
        return tags;
    }
}
