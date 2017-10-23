package edu.austral.models;

import edu.austral.util.Vector2;
import edu.austral.view.VShip;
import edu.austral.view.ViewPiece;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

import static processing.core.PApplet.degrees;
import static processing.core.PApplet.radians;

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


    public Shot shoot(Player player) {
        if(upgrade != null) {
            if (upgrade.getMunition() != 0) {
                return upgrade.shoot(this.position,this.direction, player, this.viewShip.getApp());

            }
        } else {
            upgrade = null;
            return regularGun.shoot(this.position, this.direction.$times(10), player, this.viewShip.getApp());
            }
            return null;
    }

    public void move(float x, float y) {
        this.position = this.position.$plus(new Vector2(x, y));
        this.viewShip.draw(this.position.x(), this.position.y());
    }
    
    public void rotate(float angle) {
        /*
        this.direction = this.direction.rotate(angle);
        this.viewShip.rotate(angle);
        System.out.println(degrees(this.direction.angle()));
        */
    }

    public void upgradeGun(Gun newGun){
        upgrade = newGun;
    }

    public ViewPiece getVShip() {
        return viewShip;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Ship(String model, Vector2 position, PApplet app) {
        this.model = model;
        this.position = position;
        this.direction = new Vector2(0, -1);

        this.viewShip = new VShip(app, this.position);
        List<Vector2> vectors = new ArrayList<>();
        vectors.add(new Vector2(1, 0));

        this.regularGun = new Gun(1, 1, vectors, this.position);

    }

    public Vector2 getDirection() {
        return direction;
    }
}
