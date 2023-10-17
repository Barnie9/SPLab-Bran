package app.classes;

import lombok.Getter;
import lombok.Setter;

public abstract class Element {

    @Getter
    @Setter
    private Element parent = null;

    abstract void print();
    abstract void add(Element element) throws Exception;
    abstract void remove(Element element);
    abstract Element get(int index);
}
