package com.isep.rpg;

public class Mage extends SpellCaster {

    public Mage(String n,int h, int d, int b, int p, int m) {
        super(n, h, d, b, p, m);
    }

    @Override
    public void fight(Combatant combatant) {
        combatant.looseHealthPoint(weapon.getDamagePoints() + getAttackDamage() + getBonusDamage() );
    }
    @Override
    public void take(Item item) {
        if(item instanceof Weapon){
            weapon = (Weapon) item;
        }
        else {
            Game.displayMessage("Oups ! " + item.getName() + " est inutile...");
        }
    }
    private Weapon weapon;

}
