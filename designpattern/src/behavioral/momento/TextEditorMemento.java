package behavioral.momento;

public class TextEditorMemento {
    private String content;
    public TextEditorMemento (String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}
