package main;

import service.RepositoryService;

public class Main {
    public static void main(String args[]) {
        Main app = new Main();
        app.testRepo();
        app.testLoadView();
    }

    private void testRepo() {
        var repo = new Repository(); //Model
        repo.add(new Image("TheImage", "C:\Users\Acer\Downloads\ThePicture.png"));
        System.out.println(repo);
        var service = new RepositoryService(); //Logic
        var repo = service.load("c:/repo.txt"); //or .json, .xml, .ser, ...
        service.view(repo.findImageByName("Duke"));

        System.out.println(repo);


        // Add a new image
        loadedRepo.add(new Image("TheImage", "C:\Users\Acer\Downloads\ThePicture.png"));

        // Save repository back to file
        service.save(loadedRepo);
    }
}