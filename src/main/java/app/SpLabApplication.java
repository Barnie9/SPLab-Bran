package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpLabApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpLabApplication.class, args);

        /*Book b = new Book("The book");
        Section cap1 = new Section("Chapter 1");
        Section cap11 = new Section("Subchapter 1.1");
        Section cap2 = new Section("Chapter 2");
        cap1.add(new Paragraph("Paragraph 1"));
        cap1.add(new Paragraph("Paragraph 2"));
        cap1.add(new Paragraph("Paragraph 3"));

        cap11.add(new ImageProxy("ImageOne", 10, 10));
        cap11.add(new Image("ImageTwo"));

        cap2.add(new Paragraph("Paragraph 4"));
        cap1.add(cap11);
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("Table 1"));

        b.addContent(cap1);
        b.addContent(cap2);

        BookSaveVisitor bookSaveVisitor = new BookSaveVisitor();
        b.accept(bookSaveVisitor);
        bookSaveVisitor.exportJSON();*/

//        TableOfContentUpdate tocUpdate = new TableOfContentUpdate();
//        b.accept(tocUpdate);
//        tocUpdate.getToC().accept(new RenderContentVisitor());
    }

}
