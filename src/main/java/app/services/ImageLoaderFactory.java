package app.services;

import app.models.ImageContent;

public class ImageLoaderFactory {

    private ImageLoader imageLoader;

    public ImageLoaderFactory() {
        this.imageLoader = null;
    }

    public ImageContent createImageLoader(String url) {
        String extension = url.substring(url.indexOf('.') + 1);

        if (extension.equals("jpg")) {
            this.imageLoader = new JPGImageLoader(url);
        } else if (extension.equals("png")) {
            this.imageLoader = new PNGImageLoader(url);
        }

        return this.imageLoader.load(url);
    }

}
