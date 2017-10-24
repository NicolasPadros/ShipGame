package edu.austral.models;

import edu.austral.util.Vector2;
import edu.austral.view.VPowerUp;
import edu.austral.view.ViewPiece;
import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class PowerUp {

    //private float spawnTime;

    private Gun gun;

    private Vector2 position;

    private Vector2 direction;

    private boolean alive;

    private VPowerUp vPowerUp;

    public Vector2 getPosition() {
        return position;
    }

    public PowerUp(Vector2 position, PApplet app, Gun gun, float spawnTime) {
        this.position = position;
        this.gun = gun;
        //this.spawnTime = spawnTime;

        this.alive = true;
        PVector dirct = PVector.random2D();
        this.direction = new Vector2(dirct.x, dirct.y);

        this.vPowerUp = new VPowerUp(app, this.position, this.direction, gun);
    }

    public void update() {
        this.position = this.position.$plus(direction);

    }

    public void kill() {
        this.alive = false;
    }

    public ViewPiece getVPowerUp() {
        return vPowerUp;
    }
}
