package edu.austral.controllers;

import edu.austral.models.Asteroid;
import edu.austral.util.Vector2;
import edu.austral.view.VAsteroid;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolas-p on 19/10/17.
 */
public class AsteroidController {


    private List<Asteroid> asteroids;

    public Asteroid createAsteroid(PApplet app, Vector2 position) {
        Asteroid ast = new Asteroid(position, app);
        asteroids.add(ast);
        return ast;
    }

    public AsteroidController() {
        this.asteroids = new ArrayList<>();
    }

    public void deleteAsteroid(PApplet app, Asteroid asteroid) {
        if(asteroids.contains(asteroid)) {
            asteroids.remove(asteroid);
        }
    }

    public void update() {
        for (Asteroid asteroid : asteroids) {
            asteroid.update();
            System.out.println(asteroid.getPosition().x() + " " + asteroid.getPosition().y());
        }
    }

    public void update(PApplet app) {
        for (Asteroid asteroid : asteroids) {
            asteroid.update(app);
            System.out.println(asteroid.getPosition().x() + " " + asteroid.getPosition().y());
        }
    }
}
