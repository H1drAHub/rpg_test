package com.isep.rpg;

public class Hunter extends Hero {

    public Hunter(String n, int h, int d, int b, int p, int a) {

        super(n, h, d, b, p);
        arrow = a;
    }

    @Override
    public void fight(Combatant combatant) {
        combatant.looseHealthPoint( weapon.getDamagePoints() + getAttackDamage() +getBonusDamage() );
    }

    @Override
    public void take(Item item) {
        if (item instanceof Weapon) {
            weapon = (Weapon) item;
        } else {
            Game.displayMessage("Oups ! " + item.getName() + " est inutile...");
        }
    }

    public int getArrow() {return arrow;}
    public void arrow(int i) {
        if(i==1){
            arrow +=1;
        } else if (i==0) {
            arrow -=1;
        }
        else {
            System.out.println("ERROR, only 1(+nbr) or 0(-nbr) accept ");
        }
    }

    private Weapon weapon;
    private int arrow;
}

