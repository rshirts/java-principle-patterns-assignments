package com.example.java;

public class Troll extends Character {

    public Troll() {
        System.out.println("Trace: Troll Created.");
        weaponBehavior = new AxeBehavior();
    }
    @Override
    public void fight() {
        System.out.println("The Troll starts to fight!");
        weaponBehavior.useWeapon();
    }
}
