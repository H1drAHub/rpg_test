package com.isep.rpg;

public class Dragon extends Ennemy {

    public Dragon(String n) {
        super(n, 20, 5,0,0);
    }
    @Override
    public void fight(Combatant combatant) {
        combatant.looseHealthPoint( getAttackDamage() );
    }
}
