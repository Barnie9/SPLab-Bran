package app.classes;

public class Table implements Element{

    private String title;

    public Table(String title) {
        this.title = title;
    }

    public void print() {
        System.out.println("\t\t\tTable with title: " + this.title);
    }
}
