package com.company;

/**
 * Created by Ivan on 10/29/2015.
 */
public class Warrior extends GameCharacter {

    private static final int BASE_HEALTH = 5000;
    private static final int BASE_POWER = 200;
    private static final int BASE_ENERGY = 2000;
    private static final int BASE_ATTACK_COST = 150;
    private static final Double SURGE_THRESHOLD = 0.3;
    private static final Double BLOCK_THRESHOLD = 0.6;

    public Warrior(int health, int power, int energy, int attackCost, String name) {
        super(health, power, energy, attackCost, name);
    }

    public Warrior(String name) {
        this(BASE_HEALTH, BASE_POWER, BASE_ENERGY, BASE_ATTACK_COST, name);
    }

    @Override
    public void attack(GameCharacter other) throws OutOfEnergyException {
        if (this == other) {
            throw new IllegalStateException("Cannot attack itself");
        }

        if (this.getEnergy() < this.getAttachCost()) {
            throw  new OutOfEnergyException(this.getName() + "is out of energy. Battle is over");
        }

        boolean surgeOfPower = Math.random() < SURGE_THRESHOLD;

        if (surgeOfPower) {
            System.out.println(this.getName() + " was lucky. Free attack.");
        } else {
            this.setEnergy(this.getEnergy() - this.getAttachCost());
        }

        other.respond(this.getPower());
    }

    @Override
    public void respond(int damage) {
        boolean hasBlocked = Math.random() < BLOCK_THRESHOLD;
        if (hasBlocked) {
            System.out.println("Attack was blocked!");
            damage = damage / 2;
        }
        this.setHealth(this.getHealt() - damage);
        System.out.println(damage + " damage dealt.");
    }
}
