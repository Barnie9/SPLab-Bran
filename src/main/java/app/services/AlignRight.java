package app.services;

public class AlignRight implements AlignStrategy {

    public void render(String context) {
        System.out.println("\t\t\t\t" + context);
    }

}
