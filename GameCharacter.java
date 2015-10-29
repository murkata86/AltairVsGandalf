package com.company;

/**
 * Created by Ivan on 10/29/2015.
 */
public abstract class GameCharacter {
    private int health;
    private int power;
    private int energy;
    private int attachCost;
    private String name;

    public abstract void attack(GameCharacter other) throws OutOfEnergyException;
    public abstract void respond(int damage);

    public GameCharacter(int health, int power, int energy, int attachCost, String name) {
        this.health = health;
        this.power = power;
        this.energy = energy;
        this.attachCost = attachCost;
        this.name = name;
    }



    public int getHealt() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getEnergy() {
        return this.energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getAttachCost() {
        return this.attachCost;
    }

    public void setAttachCost(int attachCost) {
        this.attachCost = attachCost;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

