package stackoverflow;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        StackOverflow system = new StackOverflow();

        // Create users
        User alice = system.createUser("Alice", "alice@example.com");
        User bob = system.createUser("Bob", "bob@example.com");
        User charlie = system.createUser("Charlie", "charlie@example.com");

        // Alice asks a question
        Question question = system.askQuestion(alice, "How to implement a stack?",
            "I'm trying to implement a stack in Java. Can anyone help?",
                Arrays.asList("java", "data-structures"));

        // Bob answers the question
        Answer answer = system.answerQuestion(bob, question, "You can use an ArrayList to implement a stack. Here's a simple example:\n\n```java\nimport java.util.ArrayList;\n\npublic class Stack<T> {\n    private ArrayList<T> elements = new ArrayList<>();\n\n    public void push(T item) {\n        elements.add(item);\n    }\n\n    public T pop() {\n        if (elements.isEmpty()) {\n            throw new EmptyStackException();\n        }\n        return elements.remove(elements.size() - 1);\n    }\n\n    public boolean isEmpty() {\n        return elements.isEmpty();\n    }\n}\n```");


        // Charlie comments on the question
        Comment comment = system.addComment(charlie, question, "This is a great question! I had the same issue last week.");

        // Charlie comments on the answer
        Comment answerComment = system.addComment(charlie, answer, "Thanks for the example! It really helped me understand stacks better.");

        // Charlie votes on the question
        system.vote(charlie, question, VoteType.UPVOTE);
    }
}
