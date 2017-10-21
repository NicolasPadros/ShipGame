package edu.austral.models;

import edu.austral.util.Vector2;
import edu.austral.view.VShip;
import edu.austral.view.ViewPiece;
import processing.core.PApplet;

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

    public void move(float x, float y) {
        this.position = this.position.$plus(new Vector2(x, y));
        this.viewShip.draw(this.position.x(), this.position.y());
    }
    
    public void rotate(float angle) {
        this.direction = this.direction.rotate(angle);
        this.viewShip.rotate(angle);
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
        this.direction = new Vector2(1, 0);

        this.viewShip = new VShip(app, this.position);

    }

    public Vector2 getDirection() {
        return direction;
    }
}
