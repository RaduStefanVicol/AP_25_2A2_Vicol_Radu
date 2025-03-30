package model;
import java.util.ArrayList;
public class Repository {
    ArrayList<Image> images = new ArrayList<Image>(); // Create an ArrayList object
    public void AddImage(Image i){
        images.add(i);
    }
}
