package russian.gb.FinalWork;

import java.util.Scanner;

public class GameViewImpl implements GameView {
    private Scanner scanner;

    public GameViewImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int getMenuChoice() {
        // Реализуйте логику вывода меню и получения выбора пользователя.
        System.out.println("Меню \n" +
                "1. Игровой автомат с мягкими игрушками.\n" +
                "2. Игровой автомат с гаджетами.\n" +
                "3. Игровой автомат с акксесуарами. \n" +
                "4. Выход\n" +
                "Выберите Игровой автомат.");
        return scanner.nextInt(); // Замените на свою логику.
    }

    @Override
    public void displayResult(boolean win) {
        // Реализуйте логику отображения результата пользователю.
        if (win) {
            System.out.println("Вы выиграли!");
        } else {
            System.out.println("Вы проиграли.");
        }
    }
}
