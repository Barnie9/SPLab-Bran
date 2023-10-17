package app.classes;

import java.util.ArrayList;
import java.util.List;

public class Book extends Section{

    private List<Author> authorList;

    public Book(String title) {
        super(title);
        this.authorList = new ArrayList<>();
    }

    public void addAuthor(Author author) {
        authorList.add(author);
    }

    public void addContent(Element element) {
        super.add(element);
    }

    public void print() {
        System.out.println("Book: " + super.getTitle());
        System.out.println();
        if (!authorList.isEmpty()) {
            System.out.println("Authors: ");
            authorList.get(0).print();
            for (int i = 1; i < authorList.size(); i++) {
                authorList.get(i).print();
            }
            System.out.println();
        }
        for (Element element : super.elementList) {
            element.print();
        }
    }
}
