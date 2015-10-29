package com.company;

/**
 * Created by Ivan on 10/29/2015.
 */
public class Mage extends GameCharacter {

    private static final int BASE_HEALTH = 5000;
    private static final int BASE_POWER = 150;
    private static final int BASE_ENERGY = 2500;
    private static final int BASE_ATTACK_COST = 250;
    private static final double CTITICAL_HIT_THRESHOLD = 0.5;
    private static final double HAS_TELEPORTED_THRESHOLD = 0.5;

    public Mage(int health, int power, int energy, int attackCost, String name) {
        super(health, power, energy, attackCost, name);

    }

    public Mage(String name) {


        this(BASE_HEALTH, BASE_POWER, BASE_ENERGY, BASE_ATTACK_COST, name);
    }

    @Override
    public void attack(GameCharacter other) throws OutOfEnergyException {
        if (other == this) {
            throw new IllegalStateException("Cannot attack itself");
        }

        if (this.getEnergy() < this.getAttachCost()) {
            throw new OutOfEnergyException(this.getName() + "is out of energy. Battle is over");
        }

        boolean isCritical = Math.random() < CTITICAL_HIT_THRESHOLD;

        int damage = this.getPower();

        if (isCritical) {
            System.out.println("Critical strike by the mage!");
            damage = damage * 2;
        }

        this.setEnergy(this.getEnergy() - this.getAttachCost());

        other.respond(damage);
    }

    @Override
    public void respond(int damage) {

        boolean hasTeleported = Math.random() < HAS_TELEPORTED_THRESHOLD;

        if (hasTeleported) {
            System.out.println("The mage has teleported and evaded the attack");
        } else {
            this.setHealth(this.getHealt() - damage);
            System.out.println("Succesfull attack. " + damage + " damage dealt");
        }

    }

}
