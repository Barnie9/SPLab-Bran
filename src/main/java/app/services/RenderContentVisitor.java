package app.services;

import app.model.*;

public class RenderContentVisitor implements Visitor {


    @Override
    public void visitBook(Book book) {
        System.out.println(book.getTitle());
    }

    @Override
    public void visitSection(Section section) {
        System.out.println(section.getTitle());
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        paragraph.print();
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        imageProxy.print();
    }

    @Override
    public void visitImage(Image image) {
        image.print();
    }

    @Override
    public void visitTable(Table table) {
        table.print();
    }

    @Override
    public void visitTableOfContent(TableOfContent tableOfContent) {
        tableOfContent.print();
    }
}
