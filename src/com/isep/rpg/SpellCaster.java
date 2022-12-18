package com.isep.rpg;

public abstract class SpellCaster extends Hero {

    public SpellCaster(String n, int h, int d, int b, int p, int m) {
        super(n, h, d, b, p);
        mana = m;
    }

    public int getMana() {return mana;}
    public void setMana(int i, int nbr) {
        if(i == 1) {
            mana += nbr;
        }
        else if (i == 0) {
            mana -= nbr;
        }
        else{
            System.out.println("ERROR, only 1(+nbr) or 0(-nbr) accept ");
        }
    }

    private int mana;
}
