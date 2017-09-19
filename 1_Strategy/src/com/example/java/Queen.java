package com.example.java;

public class Queen extends Character {

    public Queen() {
        System.out.println("Trace: Queen Created.");
        weaponBehavior = new BowAndArrowBehavior();
    }
    @Override
    public void fight() {
        System.out.println("The Queen starts to fight!");
        weaponBehavior.useWeapon();
    }
}
