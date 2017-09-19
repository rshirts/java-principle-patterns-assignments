package com.example.java;

public class AxeBehavior implements WeaponBehavior {

    public AxeBehavior() {
        System.out.println("Trace: an axe is equipped.");
    }

    @Override
    public void useWeapon() {
        System.out.println("They start chopping with the axe wildly!");
    }
}
