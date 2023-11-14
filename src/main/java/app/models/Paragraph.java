package app.models;

import app.services.AlignStrategy;

public class Paragraph extends Element {

    private String text;
    private AlignStrategy alignStrategy;

    public Paragraph(String text) {
        this.text = text;
        this.alignStrategy = null;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    public void print() {
        if (this.alignStrategy != null) {
            this.alignStrategy.render("Paragraph: " + this.text);
        } else {
            System.out.println("Paragraph: " + this.text);
        }
    }
}
