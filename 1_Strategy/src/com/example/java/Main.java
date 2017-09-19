package com.example.java;

public class Main {

    public static void main(String[] args) {
        Character king = new King();
        Character queen = new Queen();
        Character knight = new Knight();
        Character troll = new Troll();

        troll.fight();
        knight.fight();
        System.out.println("\nThe troll kills the knight!!! \n");
        queen.fight();
        king.fight();
        System.out.println("The Kind and Queen kill the troll. \n");
        System.out.println("The King reaches for the trolls weapon.");
        king.setWeapon(new AxeBehavior());
        king.fight();
    }
}
