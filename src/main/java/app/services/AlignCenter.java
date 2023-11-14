package app.services;

import app.services.AlignStrategy;

public class AlignCenter implements AlignStrategy {

    public void render(String context) {
        System.out.println("\t\t" + context);
    }

}
