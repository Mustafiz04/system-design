package behavioral.momento;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<TextEditorMemento> momentos = new ArrayList<>();

    public void saveSnapshot(TextEditorMemento momento) {
        momentos.add(momento);
    }

    public TextEditorMemento getSnapshot(int index) {
        return momentos.get(index);
    }
}
