package com.isep.rpg;

import com.isep.utils.InputParser;
//import com.sun.nio.sctp.SendFailedNotification;

//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Game {
    public Game(InputParser inputParser) {

        heros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir le nombre de héros");
        int nbrHeros = scanner.nextInt();
        while(nbrHeros>4){
            System.out.println("4 héros maximun !");
            nbrHeros = scanner.nextInt();
        }

        for (int i = 0; i < nbrHeros; i++) {
            System.out.println("Classe de votre héro n°: " + (i+1) );
            System.out.println("-1 : Warrior");
            System.out.println("-2 : Mage");
            System.out.println("-3 : Healer");
            System.out.println("-4 : Hunter");

        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Saisir la classe du héros n°: " + (i+1) );
        }
            int classSelect = scanner.nextInt();
            switch (classSelect) {
                case 1 -> {
                    System.out.println("saisir le nom de votre Warrior (héro n°" + (i + 1) + ") :");
                    String nomWarrior = scanner.next();
                    Hero warrior = new Warrior(nomWarrior, 50, 10, 0,0);
                    warrior.take(new Weapon("knife", 5,0));
                    heros.add(warrior);
                }
                case 2 -> {
                    System.out.println("saisir le nom du Mage (héro n°" + (i + 1) + ") :");
                    String mageName = scanner.next();
                    Hero mage = new Mage(mageName, 40, 9, 0, 0,5);
                    mage.take(new Weapon("Damage wand", 8,0));
                    heros.add(mage);
                }
                case 3 -> {
                    System.out.println("saisir le nom de votre Healer (héro n°" + (i + 1) + ") :");
                    String healerName = scanner.next();
                    Hero healer = new Healer(healerName, 40, 9, 0, 0,5);
                    healer.take(new Weapon("Heal wand", 1,0));
                    heros.add(healer);
                }
                case 4 -> {
                    System.out.println("saisir le nom de votre Hunter (héro n°" + (i + 1) + ") :");
                    String hunterName = scanner.next();
                    Hero hunter = new Hunter(hunterName, 30, 8, 0, 0,5);
                    hunter.take(new Weapon("Bow", 15,0));
                    heros.add(hunter);
                }
                default -> i--;
            }
        }


    }

    public void start() {
        consumableList();
        for (int i = 1; i <= 5; i++) {
            if(i!=1) {
                fightRewards();
            }
            delayTime();
            level +=1 ;
            enemiesSpawn();
            while (true) {

                choiceAction();

                if (enemies.size() == 0) {
                    displayMessage("BRAVO, les héros ont réussi, le level n°: " + level + "!!!");
                    break;
                }

                int isHero = ramdon(heros.size());
                Combatant goodOne = heros.get(isHero);
                Combatant badOne = enemies.get(ramdon(enemies.size()));

                displayMessage("Le méchant " + badOne.getName()
                        + " attaque le gentil " + goodOne.getName() + "...");
                badOne.fight(goodOne);
                if (goodOne.getHealthPoint() <= 0) {
                    displayMessage
                            ("Le pauvre " + goodOne.getName() + " a été vaincu...");
                    heros.remove(isHero);
                    isHero--;
                }

                if (heros.size() == 0) {
                    displayMessage("Les héros ont perdu, c'est la fin du monde...");
                    break;
                }
            }
        }
    }

    private void enemiesSpawn(){
        enemies = new ArrayList<>();
        switch(level) {
            case 1 :
                for (int j = 0; j<heros.size(); j++) {
                    enemies.add(new Dragon("Dragon"));
                }
                break;

            case 2 :
                for (int j = 0; j<heros.size()*2; j++) {
                    enemies.add(new Dragon("Dragon"));
                }
                break;

            case 3 :
                for (int j = 0; j<heros.size()*3; j++) {
                    enemies.add(new Dragon("Dragon"));
                }
                break;

            case 4 :
                for (int j = 0; j<heros.size()*4; j++) {
                    enemies.add(new Dragon("Dragon"));
                }
                break;

            case 5 :
                for (int j = 0; j<heros.size()*5; j++) {
                    enemies.add(new Dragon("Dragon"));
                }
                break;

        }
    }

    private void consumableList() {
        consumable = new ArrayList<>();
        Food braid = new Food("Braid", 10, 3, 0);
        consumable.add(braid);
        Potion manaPotion = new Potion("Mana potion", 5, 5, 0);
        consumable.add(manaPotion);
    }

    private void delayTime() {
        System.out.println("Press any button to continue to level " + (level+1) );
        Scanner scanner = new Scanner(System.in);
        String press = scanner.nextLine();
    }

    private void choiceAction() {
        System.out.println("""
                Choice action :
                
                1- Attack enemies
                2- Defense to enemies attack
                3- Use consumable
                """);

        Scanner scanner = new Scanner(System.in);
        int selectAction = scanner.nextInt();
        while(selectAction>3){
            System.out.println("Choose action (numbers between 1 and 5) !");
            selectAction = scanner.nextInt();
        }
        switch(selectAction) {

            case 1 :
                System.out.println("Select Hero who attack ?");
                displayHeros();
                System.out.println();
                int selectHero = scanner.nextInt();
                Combatant goodOne = heros.get(selectHero-1);
                System.out.println("Who enemy attack ?");
                displayEnemies();
                System.out.println();
                int selectEnemy = scanner.nextInt();
                Combatant badOne = enemies.get(selectEnemy-1);

                displayMessage("Le gentil " + goodOne.getName()
                        + " attaque le méchant " + badOne.getName() + "...");
                goodOne.fight(badOne);
                if (badOne.getHealthPoint() <= 0) {
                    displayMessage("Bravo, " + goodOne.getName()
                            + " a vaincu " + badOne.getName() + " !!!");
                    enemies.remove(0);
                }
                break;

            case 2 :
                System.out.println("Select Hero who use defence ?");
                displayHeros();
                System.out.println();
                int heroDef = scanner.nextInt();
                heros.get(heroDef-1).defenceState(1);
                break;

            case 3 :
                System.out.println("Who consumable you want to use ?");
                for(int i =0; i< consumable.size(); i++) {
                    System.out.println((i + 1) + "- " + consumable.get(i).getCapacity() + " " + consumable.get(i).getName());
                }
                int consumableSelect = scanner.nextInt();
                System.out.println("Who hero you want to upgrade life/mana ?");
                for (int i = 0; i < heros.size(); i++) {
                    System.out.println((i + 1) + "- " + heros.get(i).getName() + " (Attack damage: " + heros.get(i).getAttackDamage() + heros.get(i).getBonusDamage() + ")");
                }
                int heroSelect = scanner.nextInt();
                heros.get(heroSelect).restoreLife(consumable.get(consumableSelect).getRestore());
                }

        }


    private void fightRewards() {
        System.out.println("""
        Choice reward :
        
        1- increase hero damage
        2- increase hero defense
        3- increase consumable efficiency
        4- increase consumable capacity
        5- increase arrow capacity
        """);
        Scanner scanner = new Scanner(System.in);
        int selectedRewards = scanner.nextInt();
        while(selectedRewards>5){
            System.out.println("Choose rewards (numbers between 1 and 5) !");
            selectedRewards = scanner.nextInt();
        }

        switch (selectedRewards) {
            case 1 -> {
                System.out.println("Who hero you want to upgrade damage attack ?");
                for (int i = 0; i < heros.size(); i++) {
                    System.out.println((i + 1) + "- " + heros.get(i).getName() + " (Attack damage: " + heros.get(i).getAttackDamage() + heros.get(i).getBonusDamage() + ")");
                }
                int heroReward1 = scanner.nextInt();
                System.out.println(heros.get(heroReward1 - 1).getName() + " increase attack");
                heros.get(heroReward1 - 1).increaseBonusDamage(ramdon(10));
            }

            case 2 -> {
                System.out.println("Who hero you want to upgrade defense ?");
                for (int i = 0; i < heros.size(); i++) {
                    System.out.println((i + 1) + "- " + heros.get(i).getName() + " (Protection: " + heros.get(i).getProtection() + ")");
                }
                int heroReward2 = scanner.nextInt();
                System.out.println(heros.get(heroReward2 - 1).getName() + " increase defense");
                heros.get(heroReward2 - 1).increaseProtection(ramdon(5));
            }

            case 3 -> {
                System.out.println("Who consumable you want to upgrade efficiency ?");
                for(int i =0; i< consumable.size(); i++) {
                    System.out.println((i + 1) + "- " + consumable.get(i).getCapacity() + " " + consumable.get(i).getName());
                    int consumableSelect = scanner.nextInt();
                    consumable.get(consumableSelect-1).upRestore(ramdon(3));
                }
             }

             case 4 -> {
                 System.out.println("Who consumable you want to upgrade capacity ?");
                 for(int i =0; i< consumable.size(); i++) {
                     System.out.println((i + 1) + "- " + consumable.get(i).getCapacity() + " " + consumable.get(i).getName());
                 }
                 int consumableSelect = scanner.nextInt();
                 consumable.get(consumableSelect-1).capacity(1,1);
             }
             case 5 -> {
                 System.out.println(" Who hero you want to upgrade defense ?");

             }
        }
    }




    private int ramdon(int r) {
        Random random = new Random();
        return random.nextInt(r);
    }

    private InputParser inputParser;

    public void displayHeros() {
        System.out.println("##################################################");
        for (int c = 0; c < heros.size(); c++) {
            System.out.print("[" + (c+1) + "]" + heros.get(c).getName() + "(" + heros.get(c).getHealthPoint() + ") ");
        }
    }
    public void displayEnemies() {
        System.out.println();
        for (int e = 0; e<enemies.size(); e++) {
            System.out.print("[" + (e+1) + "]" + enemies.get(e).getName() + "(" + enemies.get(e).getHealthPoint() + ") ");
        }
        System.out.println();
    }
    public List<Combatant> heros;
    public List<Combatant> enemies;
    public List<Consumable> consumable;
    int level = 0;
    public static void displayMessage(String message) {
        System.out.println(message);
    }
}

