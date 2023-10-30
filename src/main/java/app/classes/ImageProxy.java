package app.classes;

public class ImageProxy extends Element implements Picture {

    private String imageName;
    private Image realImage;

    public ImageProxy(String imageName) {
        this.imageName = imageName;
        realImage = null;
    }

    public Image loadImage() {
        if (realImage == null) {
            realImage = new Image(this.imageName);
        }
        return realImage;
    }

    @Override
    void print() {
        this.loadImage();
        this.realImage.print();
    }
}
