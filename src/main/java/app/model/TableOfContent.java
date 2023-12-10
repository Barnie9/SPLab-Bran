package app.model;

import java.util.ArrayList;
import java.util.List;

public class TableOfContent extends Element {

    private List<String> entries;

    public TableOfContent() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(String entry) {
        this.entries.add(entry);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTableOfContent(this);
    }

    @Override
    public void print() {
        System.out.println("TableOfContent");
        for (String entry : this.entries) {
            System.out.println(entry);
        }
    }
}
