package com.example.java;

public abstract class Character {

    WeaponBehavior weaponBehavior;

    public abstract void fight();

    public void setWeapon(WeaponBehavior wb) {
        this.weaponBehavior = wb;
    }
}
