package stackoverflow;

import java.util.*;
public class Answer implements Commentable, Votable {
    private final int id;
    private final String content;
    private final User author;
    private final long createdAt;
    private boolean isAccepted;
    private final Question question;
    private final List<Comment> comments;
    private final List<Vote> votes;

    public Answer(String content, User author, Question question) {
        this.id = generateId();
        this.content = content;
        this.author = author;
        this.question = question;
        this.createdAt = System.currentTimeMillis();
        this.isAccepted = false;
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
    }

    @Override
    public void vote(User voter, VoteType voteType) {
        votes.removeIf(v -> v.getVoter().equals(voter));
        votes.add(new Vote(voter, voteType));
        voter.updateReputation(voteType == VoteType.UPVOTE ? 10 : -10);
    }

    public void makeAccepted() {
        if (this.isAccepted) {
            throw new IllegalStateException("This answer is already accepted.");
        }
        this.isAccepted = true;
        question.setAcceptedAnswer(this);
        author.updateReputation(15);
    }

    @Override
    public synchronized void addComment(Comment comment) {
        this.comments.add(comment);
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

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public Question getQuestion() {
        return question;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
