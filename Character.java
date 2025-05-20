public abstract class Character {
    protected String name;
    protected int maxHp;
    protected int hp;
    protected int strength;
    protected int agility;

    public Character(String name, int hp, int strength, int agility) {
        this.name = name;
        this.maxHp = hp;
        this.hp = hp;
        this.strength = strength;
        this.agility = agility;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }
}