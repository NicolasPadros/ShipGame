package edu.austral.controllers;

import edu.austral.models.Asteroid;
import edu.austral.util.Vector2;
import processing.core.PApplet;

/**
 * Created by nicolas-p on 24/10/17.
 */
public class FixedCreator implements AsteroidCreator {

    Vector2 direction;
    @Override
    public Asteroid createAsteroid(PApplet app) {
        return new Asteroid(new Vector2((float)Math.random() * app.width,
                (float) Math.random() * app.height), app, this.direction);
    }

    public FixedCreator(Vector2 direction) {
        this.direction = direction;
    }
}
