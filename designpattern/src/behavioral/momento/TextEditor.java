package behavioral.momento;

import java.util.LinkedList;

public class TextEditor {
    private String content = "";
    private LinkedList<TextEditorMemento> history = new LinkedList<>();
    private int currentIndex = -1;

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
        save();
    }

    private void save() {
        TextEditorMemento memento = new TextEditorMemento(content);
        history.add(memento);
        currentIndex = history.size() - 1;
    }

    public void undo() {
        if (currentIndex > 0) {
            currentIndex--;
            restore();
        }
    }

    public void redo() {
        if (currentIndex < history.size() - 1) {
            currentIndex++;
            restore();
        }
    }

    public void restore() {
        TextEditorMemento memento = history.get(currentIndex);
        this.content = memento.getContent();
    }
}
