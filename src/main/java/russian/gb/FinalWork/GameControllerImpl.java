package russian.gb.FinalWork;

public class GameControllerImpl implements GameController {
    private GameModel model;
    private GameView view;

    public GameControllerImpl(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void playGame() {
        int choice = view.getMenuChoice();
        boolean win = model.playGame(choice);
        view.displayResult(win);
    }
}

