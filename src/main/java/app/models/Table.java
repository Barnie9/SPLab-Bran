package app.models;

import lombok.Getter;

public class Table extends Element {

    @Getter
    private String title;

    public Table(String title) {
        this.title = title;
    }

    public void accept(Visitor visitor) {
        visitor.visitTable(this);
    }

    public void print() {
        System.out.println("Table with title: " + this.title);
    }
}
