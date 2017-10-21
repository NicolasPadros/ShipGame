package edu.austral.controllers;

import edu.austral.models.Asteroid;
import edu.austral.util.Vector2;
import edu.austral.view.VAsteroid;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.Iterator;
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

    public void deleteAsteroid(Asteroid asteroid) {
        if(asteroids.contains(asteroid)) {
            asteroids.remove(asteroid);
        }
    }


    public void update(PApplet app, UIController uiController) {
        Iterator<Asteroid> asteroidsIter = asteroids.iterator();
        while(asteroidsIter.hasNext()){
            Asteroid asteroid = asteroidsIter.next();
            if (asteroid.getPosition().y() < 0 || asteroid.getPosition().y() > app.height + 15
                    || asteroid.getPosition().x() < 0 || asteroid.getPosition().x() > app.width + 15) {
                asteroidsIter.remove();
                uiController.deleteElement(asteroid.getVAsteroid());
                asteroid.kill();
            }
                asteroid.update(app);
                System.out.println(asteroid.getPosition().x() + " " + asteroid.getPosition().y());

        }
    }




}
