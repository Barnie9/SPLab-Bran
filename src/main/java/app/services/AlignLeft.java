package app.services;

import app.services.AlignStrategy;

public class AlignLeft implements AlignStrategy {

    public void render(String context) {
        System.out.println(context);
    }

}
