package app.classes;

import java.util.ArrayList;
import java.util.List;

public class Chapter {

    private String name;
    private List<SubChapter> subChapterList;

    public Chapter(String name) {
        this.name = name;
        subChapterList = new ArrayList<>();
    }

    public int createSubChapter(String name) {
        SubChapter subChapter = new SubChapter(name);
        subChapterList.add(subChapter);
        return subChapterList.indexOf(subChapter);
    }

    public SubChapter getSubChapter(int index) {
        return subChapterList.get(index);
    }

    public void print() {
        System.out.println("\tChapter: " + this.name);
        for (SubChapter subChapter : subChapterList) {
            subChapter.print();
        }
    }
}
