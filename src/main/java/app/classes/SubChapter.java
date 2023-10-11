package app.classes;

import java.util.ArrayList;
import java.util.List;

public class SubChapter {

    private String name;
    private List<Element> elementList;

    public SubChapter(String name) {
        this.name = name;
        this.elementList = new ArrayList<>();
    }

    public void createNewParagraph(String text) {
        elementList.add(new Paragraph(text));
    }

    public void createNewImage(String imageName) {
        elementList.add(new Image(imageName));
    }

    public void createNewTable(String title) {
        elementList.add(new Table(title));
    }

    public void print() {
        System.out.println("\t\tSubchapter: " + this.name);
        for (Element element : elementList) {
            element.print();
        }
    }
}
