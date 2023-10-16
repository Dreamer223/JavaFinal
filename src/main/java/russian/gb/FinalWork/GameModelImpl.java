package russian.gb.FinalWork;

import java.util.ArrayList;
import java.util.List;

public class GameModelImpl implements GameModel {
    private List<Toy> softToys;
    private List<Toy> gadgets;
    private List<Toy> accessories;
    private List<List<Toy>> gifts;

    public GameModelImpl(List<Toy> softToys, List<Toy> gadgets, List<Toy> accessory) {
        this.softToys = softToys;
        this.gadgets = gadgets;
        this.accessories = accessory;
        this.gifts = new ArrayList<>();
        this.gifts.add(softToys);
        this.gifts.add(gadgets);
        this.gifts.add(accessory);
    }

    public void initialize() {
        // Предположим, что у нас есть начальные параметры для каждой категории игрушек.
        int initialSoftToysAmount = 100;
        int initialGadgetsAmount = 50;
        int initialAccessoryAmount = 30;

        // Инициализируем каждую категорию игрушек с начальными значениями.
        for (Toy toy : softToys) {
            toy.setAmount(initialSoftToysAmount);
        }
        for (Toy toy : gadgets) {
            toy.setAmount(initialGadgetsAmount);
        }
        for (Toy toy : accessories) {
            toy.setAmount(initialAccessoryAmount);
        }

        // Дополнительная инициализация параметров игры, если она нужна.
    }


    public boolean playGame(int choice) {
        // Предположим, что у вас есть метод getToysByChoice, который возвращает список игрушек
        // для выбранной категории (soft toys, gadgets или accessories) в зависимости от 'choice'.
        List<Toy> chosenCategory = getToysByChoice(choice);

        // Проверяем, есть ли игрушки в выбранной категории.
        if (chosenCategory.isEmpty()) {
            System.out.println("Игрушки в этой категории закончились.");
            return false; // Нет доступных игрушек, игра проиграна.
        }

        // Генерируем случайное число, чтобы определить выигрыш.
        int randomValue = (int) (Math.random() * 100);

        // Предположим, что у вас есть метод getWinningThreshold, который возвращает порог выигрыша.
        int winningThreshold = getWinningThreshold();

        // Если сгенерированное случайное число меньше порога выигрыша, то игрок выиграл.
        boolean isWin = randomValue < winningThreshold;

        if (isWin) {
            System.out.println("Поздравляем, вы выиграли!");
            reduceToysAmount(chosenCategory);
            // Здесь вы можете реализовать логику выдачи приза (например, уменьшение количества игрушек).
        } else {
            System.out.println("Увы, это не ваш день. Попробуйте снова.");
        }

        return isWin; // Возвращаем true, если игрок выиграл, и false в противном случае.
    }

    public List<Toy> getToysByChoice(int choice) {
        List<Toy> selectedToys = new ArrayList<>();

        switch (choice) {
            case 1:
                // Выбор мягких игрушек.
                selectedToys.addAll(softToys);
                break;
            case 2:
                // Выбор гаджетов.
                selectedToys.addAll(gadgets);
                break;
            case 3:
                // Выбор аксессуаров.
                selectedToys.addAll(accessories);
                break;
            case 4:
                System.out.println("Увидимся снова. Досвидания.");
                System.exit(0);
                break;
            default:
                // В случае некорректного выбора.
                System.out.println("Некорректный выбор.");
                break;
        }

        return selectedToys;
    }
    public int getWinningThreshold() {
        // Вероятность выигрыша в процентах (от 0 до 100).
        int winningProbability = 20; // Например, 20% шанс выигрыша.

        // Преобразуем вероятность в порог, где 0% шанс - порог равен 0, 100% шанс - порог равен 100.
        int threshold = winningProbability;

        return threshold;
    }
    private void reduceToysAmount(List<Toy> selectedToys) {
        for (Toy toy : selectedToys) {
            // Предполагается, что у Toy есть метод для уменьшения количества.
            toy.setAmount(toy.getAmount()-1);
        }
    }

}
