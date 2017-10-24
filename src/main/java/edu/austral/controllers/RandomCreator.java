package edu.austral.controllers;

import edu.austral.models.Asteroid;
import edu.austral.util.Vector2;
import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by nicolas-p on 24/10/17.
 */
public class RandomCreator implements AsteroidCreator {
    @Override
    public Asteroid createAsteroid(PApplet app) {
        PVector dirct = PVector.random2D();
        Vector2 direction = new Vector2(dirct.x, dirct.y);
        Asteroid asteroid = new Asteroid(new Vector2((float)Math.random() * app.width,(float) Math.random() * app.height), app, direction);
        return asteroid;
    }
}
