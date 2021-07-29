//package com.POOCC.lab05;

/**
 * 
 */
public class Warrior {
    //Stores one of the three above types
    //public int type;
    //0 = dead, 100 = full strength
    private int health;
    private String name;
    public int damage;

    public Warrior(int health, String name) {
        this.health = health;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Warrior " + health + " " + name + '\n';
    }
    public int getDamage() {
        return damage;
    }
}
