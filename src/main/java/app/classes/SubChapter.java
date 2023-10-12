package app.classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SubChapter {

    private String name;
    private List<Element> elementList;

    public SubChapter(String name) {
        this.name = name;
        this.elementList = new ArrayList<>();
    }

    public void createNewParagraph(String text) {
        addElement(new Paragraph(text));
    }

    public void createNewImage(String imageName) {
        addElement(new Image(imageName));
    }

    public void createNewTable(String title) {
        addElement(new Table(title));
    }

    public void addElement(Element element) {
        elementList.add(element);

        elementList.sort(new Comparator<Element>() {
            @Override
            public int compare(Element el1, Element el2) {
                return el1.getSortIndex() - el2.getSortIndex();
            }
        });
    }

    public void print() {
        System.out.println("\t\tSubchapter: " + this.name);
        for (Element element : elementList) {
            element.print();
        }
    }
}
