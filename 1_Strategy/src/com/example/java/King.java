package com.example.java;

public class King extends Character {

    public King () {
        System.out.println("Trace: King Created.");
        weaponBehavior = new KnifeBehavior();
    }
    @Override
    public void fight() {
        System.out.println("The King starts to fight!");
        weaponBehavior.useWeapon();
    }
}
