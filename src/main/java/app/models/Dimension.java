package app.models;

import lombok.Getter;

public class Dimension {

    @Getter
    private int width;
    @Getter
    private int height;

    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
