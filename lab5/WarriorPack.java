//package com.POOCC.lab05;

/**
 *
 */
import java.util.*;
class SNAKE_Warrior extends Warrior {
    public SNAKE_Warrior(int health, String name) {
        super(health, name);
    }

}
class OGRE_Warrior extends Warrior {
    public OGRE_Warrior(int health, String name) {
        super(health, name);
    }
}
class MARSHMALLOW_MAN_Warrior extends Warrior {
    public MARSHMALLOW_MAN_Warrior(int health, String name) {
        super(health, name);
    }
}
public class WarriorPack {
    private Vector warriors ;

    public WarriorPack () {
        warriors = new Vector();
    }

    public void addWarrior(Warrior newWarrior) {
        warriors.add(newWarrior);
    }

    public Vector getWarriors() {
        return warriors ;
    }

    public int calculateDamage() {
        int damage = 0;
        for(int i = 0; i < warriors.size(); i++) {
            Warrior w = (Warrior) warriors.get(i);
            damage += w.getDamage();
        }
        return damage;
    }
    public String toString() {
        String result = "";
        for (int i = 0; i < warriors.size(); i++) {
            Warrior w = (Warrior) warriors.get(i);
            result += w.toString();
        }
        return result;
    }
}
