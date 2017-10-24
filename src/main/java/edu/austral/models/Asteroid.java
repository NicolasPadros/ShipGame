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
    private boolean alive;


    public Vector2 getPosition() {
        return position;
    }

    public Asteroid(Vector2 position, PApplet app, Vector2 direction, int lives) {
        this.position = position;
        this.direction = direction;
        this.alive = true;
        this.life = lives;
        /*
        PVector dirct = PVector.random2D();
        this.direction = new Vector2(dirct.x, dirct.y);
        */
        //this.direction = this.direction.$times(3);

        vAsteroid = new VAsteroid(app, this.position, this.direction, lives);
    }


    public ViewPiece getVAsteroid() {
        return vAsteroid;
    }


    public void update() {
        this.position = this.position.$plus(direction);

    }

    public boolean isAlive() {
        return alive;
    }

    public void kill() {
        alive = false;
    }
}
