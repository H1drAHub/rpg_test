package com.isep.rpg;

public class Weapon extends Item {

    public Weapon(String n, int damagePoints, int c) {
        super(n, damagePoints);
        this.damagePoints = damagePoints;
        capacity = c;
    }
    public int getCapacity() { return capacity; }

    public void capacity(int i) {
        if(i == 1) {
            capacity += 1;
        }
        else if (i == 0) {
            capacity -= 1;
        }
        else{
            System.out.println("ERROR, only 1(+nbr) or 0(-nbr) accept ");
        }
    }

    public int getDamagePoints() {
        return damagePoints;
    }
    private int damagePoints;
    private int capacity;
}
