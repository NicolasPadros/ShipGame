package edu.austral.controllers;

import edu.austral.models.Asteroid;
import edu.austral.view.VAsteroid;
import processing.core.PApplet;

import java.util.List;

/**
 * Created by nicolas-p on 19/10/17.
 */
public class AsteroidController {


    private List<Asteroid> asteroids;

    public void createAsteroid(PApplet app) {
        Asteroid ast = new Asteroid();
        asteroids.add(ast);
        VAsteroid vAsteroid = new VAsteroid(app, ast.getPosition());
        UIController.add(vAsteroid);
    }

    public void deleteAsteroid(PApplet app, Asteroid asteroid) {
        if(asteroids.contains(asteroid)) {
            asteroids.remove(asteroid);
            UIController.remove(asteroid);
        }
    }
}
