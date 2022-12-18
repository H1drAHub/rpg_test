package com.isep.rpg;

public abstract class Consumable extends Item {

    public Consumable(String n, int nbr, int r, int c) {
        super(n,nbr);
        name = n;
        max = nbr ;
        restore = r;
        capacity = c;
    }

    public String getConsumableName() { return name; }

    public int getMaxCapacity() { return max; }

    public int getRestore() { return restore; }

    public void upRestore(int point) { restore += point; }
    public int getCapacity() { return capacity; }

    public void capacity(int i, int nbr) {
        if(i == 1) {
            capacity += nbr;
        }
        else if (i == 0) {
            capacity -= nbr;
        }
        else{
            System.out.println("ERROR, only 1(+nbr) or 0(-nbr) accept ");
        }
    }

    private String name;
    private int max;
    private int restore;
    private int Life;
    private int capacity;
}


