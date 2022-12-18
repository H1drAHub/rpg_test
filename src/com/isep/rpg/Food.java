package com.isep.rpg;

public class Food extends Consumable {

    public Food(String n, int nbr, int r, int c) {
        super(n, nbr, r, c);
    }

    public int getNbr() { return nbr; }
    public void upNbr() { nbr += 1; }
    private int nbr;
    }

