package app.classes;

import java.util.ArrayList;
import java.util.List;

public class SubChapter {

    private String name;
    private List<Paragraph> paragraphList;
    private List<Image> imageList;
    private List<Table> tableList;

    public SubChapter(String name) {
        this.name = name;
        this.paragraphList = new ArrayList<>();
        this.imageList = new ArrayList<>();
        this.tableList = new ArrayList<>();
    }

    public void createNewParagraph(String text) {
        paragraphList.add(new Paragraph(text));
    }

    public void createNewImage(String imageName) {
        imageList.add(new Image(imageName));
    }

    public void createNewTable(String title) {
        tableList.add(new Table(title));
    }

    public void print() {
        System.out.println("\t\tSubchapter: " + this.name);
        for (Paragraph paragraph : paragraphList) {
            paragraph.print();
        }
        for (Image image : imageList) {
            image.print();
        }
        for (Table table : tableList) {
            table.print();
        }
    }
}
