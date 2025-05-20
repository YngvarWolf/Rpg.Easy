public class Player extends Character {
    private int level;
    private int exp;
    private int gold;
    private int potions;

    public Player() {
        super("Hero", 100, 10, 10);
        this.level = 1;
        this.exp = 0;
        this.gold = 0;
        this.potions = 1;
    }

    public void gainRewards(int exp, int gold) {
        this.exp += exp;
        this.gold += gold;
        System.out.println("Вы получили " + exp + " опыта и " + gold + " золота.");
        checkLevelUp();
    }

    private void checkLevelUp() {
        int threshold = level * 100;
        if (exp >= threshold) {
            level++;
            exp -= threshold;
            maxHp += 20;
            strength += 2;
            agility += 2;
            hp = maxHp;
            System.out.println("🎉 Уровень повышен! Теперь ваш уровень: " + level);
        }
    }

    public void heal() {
        if (potions > 0) {
            hp = Math.min(maxHp, hp + 50);
            potions--;
            System.out.println("Вы исцелились до " + hp + " HP. Осталось зелий: " + potions);
        } else {
            System.out.println("Нет зелий!");
        }
    }

    public void buyPotion() {
        if (gold >= 30) {
            gold -= 30;
            potions++;
            System.out.println("Куплено зелье!");
        } else {
            System.out.println("Недостаточно золота.");
        }
    }

    public void showStats() {
        System.out.println("====== Характеристики ======");
        System.out.println("Уровень: " + level);
        System.out.println("HP: " + hp + "/" + maxHp);
        System.out.println("Сила: " + strength);
        System.out.println("Ловкость: " + agility);
        System.out.println("Опыт: " + exp);
        System.out.println("Золото: " + gold);
        System.out.println("Зелья: " + potions);
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }
}