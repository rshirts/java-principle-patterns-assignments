package com.example.java;

public class KnifeBehavior implements WeaponBehavior {
    public KnifeBehavior() {
        System.out.println("Trace: A knife is equipped.");
    }

    @Override
    public void useWeapon() {
        System.out.println("They start cutting with the knife!");
    }
}
