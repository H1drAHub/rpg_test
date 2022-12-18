package com.isep.rpg;

public class Warrior extends Hero {

    public Warrior(String n, int h, int d, int b, int p) {
        super(n, h, d, b, p);
    }

    @Override
    public void fight(Combatant combatant) {
        combatant.looseHealthPoint( weapon.getDamagePoints() + getAttackDamage() + getBonusDamage());
    }
    @Override
    public void take(Item item) {
        if (item instanceof Weapon) {
            weapon = (Weapon) item;
        } else {
            Game.displayMessage("Oups ! " + item.getName() + " est inutile...");
        }
    }

    private Weapon weapon;
}
