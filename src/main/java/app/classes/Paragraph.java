package app.classes;

public class Paragraph extends Element {

    private String text;
    private AlignStrategy alignStrategy;

    public Paragraph(String text) {
        this.text = text;
        alignStrategy = null;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    public void print() {
        if (alignStrategy != null) {
            alignStrategy.render("Paragraph: " + this.text);
        } else {
            System.out.println("Paragraph: " + this.text);
        }
    }
}
