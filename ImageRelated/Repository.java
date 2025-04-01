package ImageRelated;
import java.util.ArrayList;

public class Repository {
    public Repository() {
    }

    public Image getFirstImage() {
        return images.getFirst();
    }

    private ArrayList<Image> images = new ArrayList<Image>();
    public void AddImage(Image i){
        try{
        this.images.add(i);
        }
        catch(IllegalArgumentException e){
            System.out.println("Something wrong with the image");
        }
    }
    public void RemoveImage(Image i) {images.removeLast();}
}
