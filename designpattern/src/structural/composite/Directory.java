package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    private String name;
    private List<FileSystem> items;

    public Directory(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addItem(FileSystem item) {
        this.items.add(item);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory " + this.name + " have these items: ");
        for(FileSystem item: items) {
            item.showDetails();
        }
    }
}
