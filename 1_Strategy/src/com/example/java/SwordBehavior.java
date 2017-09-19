package com.example.java;

public class SwordBehavior implements WeaponBehavior {

    public SwordBehavior() {
        System.out.println("Trace: A sword is equipped.");
    }

    @Override
    public void useWeapon() {
        System.out.println("They swing with the sword!");
    }
}
