package app.classes;

public class AlignCenter implements AlignStrategy {

    public void render(String context) {
        System.out.println("\t\t" + context);
    }

}
