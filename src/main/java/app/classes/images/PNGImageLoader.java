package app.classes.images;

public class PNGImageLoader implements ImageLoader {

    private String url;

    public PNGImageLoader(String url) {
        this.url = url;
    }

    public ImageContent load(String url) {
        return new ImageContent(url);
    }

}
