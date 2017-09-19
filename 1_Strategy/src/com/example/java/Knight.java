package com.example.java;

public class Knight extends Character {

    public Knight() {
        System.out.println("Trace: Knight Created.");
        weaponBehavior = new SwordBehavior();
    }
    @Override
    public void fight() {
        System.out.println("The Knight starts to fight!");
        weaponBehavior.useWeapon();
    }
}
