package russian.gb.FinalWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Toy> softToys = Toy.readToysFromFile("C:\\Users\\drack\\IdeaProjects\\JavaFinal\\src\\main\\java\\russian\\gb\\FinalWork\\toys.txt");
        List<Toy> gadgets = Toy.readToysFromFile("C:\\Users\\drack\\IdeaProjects\\JavaFinal\\src\\main\\java\\russian\\gb\\FinalWork\\gadgets.txt");
        List<Toy> accessory = Toy.readToysFromFile("C:\\Users\\drack\\IdeaProjects\\JavaFinal\\src\\main\\java\\russian\\gb\\FinalWork\\accessory.txt");

        GameModel model = new GameModelImpl(softToys, gadgets, accessory);
        GameView view = new GameViewImpl();
        GameController controller = new GameControllerImpl(model, view);
        while (true){
            controller.playGame();
        }

    }
}
