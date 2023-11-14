package app.services;

import app.models.ImageContent;

public class JPGImageLoader implements ImageLoader {

    private String url;

    public JPGImageLoader(String url) {
        this.url = url;
    }

    public ImageContent load(String url) {
        return new ImageContent(url);
    }

}
