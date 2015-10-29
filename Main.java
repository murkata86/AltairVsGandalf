package com.company;

public class Main {
    public static void main(String[] args) {
        GameCharacter theMage = new Mage("Gandalf");
        GameCharacter theWorrior = new Warrior("Altair");

        int roundCount = 0;

        while(true) {
            System.out.println("Round: " + ++roundCount);
            try {
                if (roundCount % 2 != 0) {
                    theWorrior.attack(theMage);
                    theMage.attack(theWorrior);
                } else {
                    theMage.attack(theWorrior);
                    theWorrior.attack(theMage);
                }
            } catch (OutOfEnergyException e) {
                System.out.println(e.getMessage());
                break;
            }
            System.out.println();
        }
        if (theWorrior.getHealt() > theMage.getHealt()) {
            System.out.println(theWorrior.getName() + " is winner with " + theWorrior.getHealt() + " health remaining!");
        } else if (theMage.getHealt() > theWorrior.getHealt()) {
            System.out.println(theMage.getName() + " is winner with " + theMage.getHealt() + " health remaining!");
        } else {
            System.out.println(theWorrior.getName() + " and " + theMage.getName() + " have equal health remaining - " + theMage.getHealt() + ".");
        }

    }
}


