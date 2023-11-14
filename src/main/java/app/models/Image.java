package app.models;

import app.services.ImageLoaderFactory;

import java.util.concurrent.TimeUnit;

public class Image extends Element implements Picture {

    private String url;
    private ImageContent imageContent;

    public Image(String url) {
        this.url = url;
        ImageLoaderFactory imageLoaderFactory = new ImageLoaderFactory();
        this.imageContent = imageLoaderFactory.createImageLoader(this.url);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        System.out.print(this.url);
    }
}
