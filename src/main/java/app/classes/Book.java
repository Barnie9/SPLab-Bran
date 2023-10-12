package app.classes;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private String title;
    private List<Author> authorList;
    private List<Chapter> chapterList;

    public Book(String title) {
        this.title = title;
        this.authorList = new ArrayList<>();
        this.chapterList = new ArrayList<>();
    }

    public void addAuthor(Author author) {
        authorList.add(author);
    }

    public int createChapter(String name) {
        Chapter chapter = new Chapter(name);
        chapterList.add(chapter);
        return chapterList.indexOf(chapter);
    }

    public Chapter getChapter(int index) {
        return chapterList.get(index);
    }

    public void print() {
        System.out.println("Book: " + this.title);
        if (!authorList.isEmpty()) {
            System.out.print("Authors: ");
            authorList.get(0).print();
            for (int i = 1; i < authorList.size(); i++) {
                System.out.print(", ");
                authorList.get(i).print();
            }
            System.out.println();
        }
        for (Chapter chapter : chapterList) {
            chapter.print();
        }
    }
}
