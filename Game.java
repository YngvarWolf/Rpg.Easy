import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Player player;
    private final Scanner scanner;
    private final Random random = new Random();
    private String namePlayer;

    public Game() {
        this.player = new Player();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Добро пожаловать в RPG!");
        System.out.println("Введите ваше имя: ");
        namePlayer = scanner.nextLine().toLowerCase();
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Сразиться (fight)");
            System.out.println("2. Статистика (stats)");
            System.out.println("3. Магазин (shop)");
            System.out.println("4. Исцелиться (heal)");
            System.out.println("5. Выйти (exit)");

            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "1", "fight" -> battle();
                case "2", "stats" -> player.showStats();
                case "3", "shop" -> Shop.open(player, scanner);
                case "4", "heal" -> player.heal();
                case "5", "exit" -> {
                    System.out.println("Выход из игры.");
                    return;
                }
                default -> System.out.println("Неизвестная команда. Попробуйте снова.");
            }

            if (!player.isAlive()) {
                System.out.println("💀 Вы погибли. Игра окончена.");
                break;
            }
        }
    }

    private void battle() {
        Monster monster = Monster.getRandomMonster();
        System.out.println("⚔️ Вы столкнулись с " + monster.getName());

        while (monster.isAlive() && player.isAlive()) {
            if (random.nextInt(player.getAgility() + 1) > random.nextInt(monster.getAgility() + 1)) {
                int damage = random.nextInt(player.getStrength() + 1);
                monster.takeDamage(damage);
                System.out.println("Вы нанесли " + damage + " урона.");
            } else {
                System.out.println("Вы промахнулись!");
            }

            if (!monster.isAlive()) break;

            if (random.nextInt(monster.getAgility() + 1) > random.nextInt(player.getAgility() + 1)) {
                int damage = random.nextInt(monster.getStrength() + 1);
                player.takeDamage(damage);
                System.out.println(monster.getName() + " ударил вас на " + damage + " урона.");
            } else {
                System.out.println(monster.getName() + " промахнулся!");
            }

            System.out.println("Ваш HP: " + player.getHp() + " | HP монстра: " + monster.getHp());
        }

        if (player.isAlive()) {
            System.out.println(monster.getName() + " побежден!");
            player.gainRewards(monster.getExpReward(), monster.getGoldReward());
        }
    }
}