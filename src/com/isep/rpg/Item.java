package com.isep.rpg;

public abstract class Item {

    public Item(String n, int hp) {
        name = n;
        Life = hp;
    }
    public String getName() {
        return name;
    }
    private String name;
    private int Life;
}
