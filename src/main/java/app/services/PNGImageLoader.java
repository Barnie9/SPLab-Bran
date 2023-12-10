package app.services;

import app.model.ImageContent;

public class PNGImageLoader implements ImageLoader {

    private String url;

    public PNGImageLoader(String url) {
        this.url = url;
    }

    public ImageContent load(String url) {
        return new ImageContent(url);
    }

}
