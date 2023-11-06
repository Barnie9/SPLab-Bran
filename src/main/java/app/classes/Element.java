package app.classes;

import lombok.Getter;
import lombok.Setter;

public abstract class Element {

    @Getter
    @Setter
    private Element parent = null;

    protected abstract void print();
    void add(Element element) throws Exception {}
    void remove(Element element) {}
    Element get(int index) {
        return null;
    }
}
