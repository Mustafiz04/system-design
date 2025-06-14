package stackoverflow;

import java.sql.Array;
import java.util.*;
public class Question implements Commentable, Votable {
    private final int id;
    private final String title;
    private final String content;
    private final User author;
    private final long createdAt;
    private final List<Tag> tags;
    private final List<Answer> answers;
    private final List<Comment> comments;
    private final List<Vote> votes;
    private Answer acceptedAnswer;

    public Question(String title, String content, User author, List<String> tags) {
        this.id = generateId();
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = System.currentTimeMillis();
        this.tags = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        for(String tagName: tags) {
            this.tags.add(new Tag(tagName));
        }
    }

    public synchronized void addAnswer(Answer answer) {
        if (!answers.contains(answer)) {
            answers.add(answer);
        }
    }

    @Override
    public void vote(User voter, VoteType voteType) {
        votes.removeIf(v -> v.getVoter().equals(voter));
        votes.add(new Vote(voter, voteType));
        voter.updateReputation(voteType == VoteType.UPVOTE ? 5 : -5);
    }

    @Override
    public synchronized void addComment(Comment comment) {
        this.comments.add(comment);
    }


    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
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

    public List<Tag> getTags() {
        return tags;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Vote> getVotes() {
        return votes;
    }
    public Answer getAcceptedAnswer() {
        return acceptedAnswer;
    }

    public void setAcceptedAnswer(Answer acceptedAnswer) {
        this.acceptedAnswer = acceptedAnswer;
    }
}
