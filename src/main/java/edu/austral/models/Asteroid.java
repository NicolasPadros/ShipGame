package edu.austral.models;

import edu.austral.util.Vector2;
import edu.austral.view.VAsteroid;
import edu.austral.view.ViewPiece;
import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class Asteroid {

    private int life;

    private Vector2 position;

    private Vector2 direction;

    private VAsteroid vAsteroid;

    public Vector2 getPosition() {
        return position;
    }

    public Asteroid(Vector2 position, PApplet app) {
        this.position = position;
        PVector dirct = PVector.random2D();
        this.direction = new Vector2(dirct.x, dirct.y);
        this.direction.$times(3);
        vAsteroid = new VAsteroid(app, this.position, this.direction);
    }

    public void update() {
        this.position = this.position.$plus(direction);
        this.vAsteroid.update();
    }

    public ViewPiece getVAsteroid() {
        return vAsteroid;
    }

    public void update(PApplet app) {
        this.position = this.position.$plus(direction);
        this.vAsteroid.update(app);
    }
}
