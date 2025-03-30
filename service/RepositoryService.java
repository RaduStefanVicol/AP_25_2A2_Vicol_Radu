package service;

import model.Image;
import model.Repository;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class RepositoryService {
    public void save(Repository repo, String path)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(path))) {
            oos.writeObject(repo);
        }
    }
    public Repository load(String path)
            throws InvalidRepositoryException {
        //use ObjectInputStream
    }
    public void view(Image img) {
        Desktop desktop = Desktop.getDesktop();
        File new imageFile = new File("C:\Users\Acer\Downloads\ThePicture.png");
        //… open
    }
}