package edu.austral.models;

import edu.austral.util.Vector2;
import edu.austral.view.VGun;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

import static processing.core.PApplet.radians;
import static processing.core.PConstants.HALF_PI;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class Gun {

    private int munition;

    private float firingRate;

    private Shot bulletShot;

    private List<Vector2> typeOfShot;

    private int damage;

    private int lastShot;

    //private VGun viewGun;

    public int getMunition() {
        return munition;
    }

    public List<Shot> shoot(Vector2 position, Vector2 direction, Player player, PApplet app) {
        List<Shot> shots = new ArrayList<>();
        if(app.millis() - lastShot < firingRate) return shots;
        for (Vector2 vector2 : typeOfShot) {
            shots.add(new Shot(player, this.damage, position.$plus(direction.$times(4)),vector2.rotate(direction.angle()+ HALF_PI).$times(direction.module()), app));
            munition-=1;
        }
        lastShot = app.millis();
        return shots;
        //return null;
    }

    public Gun(int munition, float firingRate, List<Vector2> typeOfShot, int damage) {
        this.munition = munition;
        this.firingRate = firingRate;
        //this.bulletShot = bulletShot;
        this.typeOfShot = typeOfShot;
        this.damage = damage;
    }
}
