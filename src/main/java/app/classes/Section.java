package app.classes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element{

    @Getter
    private String title;
    List<Element> elementList;

    public Section(String title) {
        this.title = title;
        elementList = new ArrayList<>();
    }

    public void add(Element element) {
        elementList.add(element);
    }

    @Override
    public void remove(Element element) {
        elementList.remove(element);
    }

    @Override
    public Element get(int index) {
        return elementList.get(index);
    }

    public void print() {
        System.out.println(this.title);
        for (Element element : elementList) {
            element.print();
        }
    }
}
