import java.util.Random;

public class Monster extends Character {
    private int expReward;
    private int goldReward;

    public Monster(String name, int hp, int strength, int agility, int exp, int gold) {
        super(name, hp, strength, agility);
        this.expReward = exp;
        this.goldReward = gold;
    }

    public static Monster getRandomMonster() {
        String[] names = {"Гоблин", "Орк", "Скелет"};
        int index = new Random().nextInt(names.length);
        switch (index) {
            case 0: return new Monster("Гоблин", 50, 6, 5, 20, 15);
            case 1: return new Monster("Орк", 80, 10, 4, 35, 25);
            default: return new Monster("Скелет", 40, 7, 7, 25, 20);
        }
    }

    public int getExpReward() {
        return expReward;
    }

    public int getGoldReward() {
        return goldReward;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }
}