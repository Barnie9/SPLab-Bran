package app.classes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Section extends Element {

    @Getter
    private String title;
    List<Element> elementList;

    public Section(String title) {
        this.title = title;
        this.elementList = new ArrayList<>();
    }

    @Override
    public void add(Element element) throws Exception {
        if (element.getParent() == null) {
            element.setParent(this);
            this.elementList.add(element);
        } else {
            throw new Exception("Element already exist!");
        }
    }

    @Override
    public void remove(Element element) {
        this.elementList.remove(element);
        element.setParent(null);
    }

    @Override
    public Element get(int index) {
        return this.elementList.get(index);
    }

    public void print() {
        System.out.println(this.title);
        for (Element element : this.elementList) {
            element.print();
        }
    }
}
