package com.isep.rpg;

import java.util.TreeMap;

public abstract class Combatant {

    public Combatant(String n, int h, int d, int b, int p) {
        name = n;
        healthPoint = h;
        damage = d;
        bonusDamage = b;
        protection = p;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public boolean getState() {return state;}

    public void defenceState(int s) {
        if(s==1){
            state = true;
        } else if (s==0) {
            state = false;
        }
        else {
            System.out.println("ERROR, only 1(true) or 0(false) accept ");
        }
    }
    public void looseHealthPoint(int point) {
        if(state) {
            if (protection < point) {
                healthPoint -= (point - protection);
                protection = 0;
            } else {
                protection -= point;
            }
            state = false;
        }
        else {
            healthPoint -= point;
        }
    }

    public void restoreLife(int hp) { healthPoint += hp;}

    public int getAttackDamage() { return damage; }

    public void increaseBonusDamage(int point) { bonusDamage += point; }

    public int getBonusDamage() { return bonusDamage; }

    public void increaseProtection(int p) {protection += p; }

    public int getProtection() { return protection; }

    public abstract void fight(Combatant combatant);
    private Boolean state=false;
    private String name;
    private int healthPoint;
    private int damage;
    private int bonusDamage;

    private int protection;
}
