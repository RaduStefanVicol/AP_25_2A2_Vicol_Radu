package main;
import ImageRelated.Image;
import ImageRelated.Repository;
import java.awt.Desktop;
import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main1= new Main();
        main1.testRepository();

    }

    private void testRepository() {
        var repo = new Repository(); //Model
        String pathName = "C:/Users/Acer/Downloads/ThePicture.png";
        Image picture1 = new Image("TheImage", LocalDate.now(), List.of("Scifi","Cool"), pathName);
        repo.AddImage(picture1);
        System.out.println(repo);
        Desktop desktop = Desktop.getDesktop();
        File imageFile = new File(repo.getFirstImage().path()); // Convert path to File object

        try {
            desktop.open(imageFile); 
        } catch (Exception e) {
            System.err.println("Failed to open the file: " + e.getMessage());
        }
    }
}