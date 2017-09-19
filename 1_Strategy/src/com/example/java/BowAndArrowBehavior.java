package com.example.java;

public class BowAndArrowBehavior implements WeaponBehavior {

    public BowAndArrowBehavior() {
        System.out.println("Trace: A bow is equipped.");
    }

    @Override
    public void useWeapon() {
        System.out.println("They aim with the bow and fire!");
    }
}
