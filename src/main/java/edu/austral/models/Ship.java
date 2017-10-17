package edu.austral.models;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class Ship {

    private String model;
    private Gun regularGun;


    public void shoot() { }

    public void move(int x, int y) {}

    public void upgradeGun(Gun newGun){
        regularGun = newGun;
    }
}
