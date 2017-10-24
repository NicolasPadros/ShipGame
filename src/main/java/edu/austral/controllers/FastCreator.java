package edu.austral.controllers;

import edu.austral.models.Asteroid;
import edu.austral.util.Vector2;
import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by nicolas-p on 24/10/17.
 */
public class FastCreator implements AsteroidCreator {


    @Override
    public Asteroid createAsteroid(PApplet app) {
        PVector dirct = PVector.random2D().mult(10);
        Vector2 direction = new Vector2(dirct.x, dirct.y);
        return new Asteroid(new Vector2((float)Math.random() * app.width,
                (float) Math.random() * app.height), app, direction, 3);
    }

}
