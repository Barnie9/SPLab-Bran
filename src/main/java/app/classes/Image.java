package app.classes;

public class Image implements Element{

    private String imageName;

    public Image(String imageName) {
        this.imageName = imageName;
    }

    public void print() {
        System.out.println("\t\t\tImage with name: " + this.imageName);
    }

    public int getSortIndex() {
        return 2;
    }
}
