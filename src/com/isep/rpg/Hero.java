package com.isep.rpg;

public abstract class Hero extends Combatant {

    public Hero(String n, int h, int d, int b, int p) {
        super(n, h, d, b, p);
    }

    public abstract void take(Item item);


}
