package app.models;

import lombok.Getter;

public class ImageProxy extends Element implements Picture {

    @Getter
    private String url;
    private Dimension dimension;
    private Image realImage;

    public ImageProxy(String url, int width, int height) {
        this.url = url;
        this.dimension = new Dimension(width, height);
        this.realImage = null;
    }

    private Image loadImage() {
        if (this.realImage == null) {
            this.realImage = new Image(this.url);
        }
        return this.realImage;
    }

    public void accept(Visitor visitor) {
        // this.loadImage();
        visitor.visitImageProxy(this);
    }

    public void print() {
        this.loadImage();

        /*
        System.out.print('/');
        for (int i = 0; i < Math.max(this.dimension.getWidth(), this.url.length()); i++) {
            System.out.print('-');
        }
        System.out.println('\\');

        for (int i = 0; i < this.dimension.getHeight() / 2; i++) {
            System.out.print('|');
            for (int j = 0; j < Math.max(this.dimension.getWidth(), this.url.length()); j++) {
                System.out.print(' ');
            }
            System.out.println('|');
        }

        System.out.print('|');
        if (this.url.length() >= this.dimension.getWidth()) {
            this.realImage.print();
        } else {
            for (int i = 0; i < (this.dimension.getWidth() - this.url.length()) / 2; i++) {
                System.out.print(' ');
            }
            this.realImage.print();
            for (int i = (this.dimension.getWidth() - this.url.length()) / 2; i < this.dimension.getWidth() - this.url.length(); i++) {
                System.out.print(' ');
            }
        }
        System.out.println('|');

        for (int i = this.dimension.getHeight() / 2 + 1; i < this.dimension.getHeight(); i++) {
            System.out.print('|');
            for (int j = 0; j < Math.max(this.dimension.getWidth(), this.url.length()); j++) {
                System.out.print(' ');
            }
            System.out.println('|');
        }

        System.out.print('\\');
        for (int i = 0; i < Math.max(this.dimension.getWidth(), this.url.length()); i++) {
            System.out.print('-');
        }
        System.out.println('/');
        */

        this.realImage.print();
    }
}
