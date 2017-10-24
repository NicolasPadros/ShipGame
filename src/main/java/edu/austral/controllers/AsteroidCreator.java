package edu.austral.controllers;

import edu.austral.models.Asteroid;
import edu.austral.util.Vector2;
import processing.core.PApplet;

/**
 * Created by nicolas-p on 24/10/17.
 */
public interface AsteroidCreator {

    public Asteroid createAsteroid(PApplet app);
}
