package edu.austral.models;

import edu.austral.util.Vector2;
import edu.austral.view.VGun;
import processing.core.PApplet;

import java.util.List;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class Gun {

    private final Vector2 position;
    private int munition;

    private float firingRate;

    private Shot bulletShot;

    private List<Vector2> typeOfShot;

    private int damage;

    //private VGun viewGun;

    public int getMunition() {
        return munition;
    }

    public Shot shoot(Vector2 position, Vector2 direction, Player player, PApplet app) {
        return new Shot(player, this.damage, position, direction, app);
        //return null;
    }

    public Gun(int munition, float firingRate, List<Vector2> typeOfShot,
               Vector2 position) {
        this.munition = munition;
        this.firingRate = firingRate;
        //this.bulletShot = bulletShot;
        this.typeOfShot = typeOfShot;
        this.position = position;
        //this.viewGun = new VGun(app, position);
    }
}
