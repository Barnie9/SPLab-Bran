package app.model;

import java.util.ArrayList;
import java.util.List;

public class Book extends Section {

    private List<Author> authorList;

    public Book(String title) {
        super(title);
        this.authorList = new ArrayList<>();
    }

    public void addAuthor(Author author) {
        this.authorList.add(author);
    }

    public void addContent(Element element) {
        try {
            super.add(element);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void accept(Visitor visitor) {
        visitor.visitBook(this);
        for (Element element : super.elementList) {
            element.accept(visitor);
        }
    }

    public void print() {
        System.out.println("Book: " + super.getTitle());
        System.out.println();
        if (!this.authorList.isEmpty()) {
            System.out.println("Authors: ");
            this.authorList.get(0).print();
            for (int i = 1; i < this.authorList.size(); i++) {
                this.authorList.get(i).print();
            }
            System.out.println();
        }
        for (Element element : super.elementList) {
            element.print();
        }
    }
}
