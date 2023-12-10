package app.services;

import app.model.ImageContent;

public class JPGImageLoader implements ImageLoader {

    private String url;

    public JPGImageLoader(String url) {
        this.url = url;
    }

    public ImageContent load(String url) {
        return new ImageContent(url);
    }

}
