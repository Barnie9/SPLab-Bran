package app.classes;

public class Paragraph implements Element{

    private String text;

    public Paragraph(String text) {
        this.text = text;
    }

    public void print() {
        System.out.println("\t\t\tParagraph: " + this.text);
    }

    public int getSortIndex() {
        return 1;
    }
}
