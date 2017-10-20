package edu.austral.models;

import edu.austral.util.Vector2;
import edu.austral.view.VShip;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class Ship {

    private String model;
    private Gun regularGun;

    private Gun upgrade;

    private Vector2 position;
    private Vector2 direction;

    private VShip viewShip;


    public void shoot() {
        if(upgrade != null) {
            if (upgrade.getMunition() != 0) {
                upgrade.shoot();
                return;
            }
        } else {
            upgrade = null;
            regularGun.shoot();
            return;
            }
    }

    public void move(int x, int y) {

    }

    public void upgradeGun(Gun newGun){
        upgrade = newGun;
    }
}
