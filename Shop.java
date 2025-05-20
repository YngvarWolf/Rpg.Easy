import java.util.Scanner;

public class Shop {
    public static void open(Player player, Scanner scanner) {
        System.out.println("🛒 Добро пожаловать в магазин!");
        System.out.println("1. Купить зелье (30 золота)");
        System.out.println("Введите номер товара или 'exit':");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            player.buyPotion();
        }
    }
}