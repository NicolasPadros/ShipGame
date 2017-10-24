package edu.austral.controllers;

import edu.austral.models.Asteroid;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nicolas-p on 19/10/17.
 */
public class AsteroidController {


    private List<Asteroid> asteroids;

    private AsteroidCreator creator1;
    private AsteroidCreator creator2;

    private boolean state;

    public Asteroid createAsteroid(PApplet app) {
        Asteroid ast;
        if(state) ast =  creator1.createAsteroid(app);
        else ast = creator2.createAsteroid(app);
        asteroids.add(ast);
        state = !state;
        return ast;
    }

    public AsteroidController() {
        this.asteroids = new ArrayList<>();
        this.creator1 = new SlowCreator();
        this.creator2 = new FastCreator();
        state = true;
    }


    public void update(PApplet app, UIController uiController) {
        Iterator<Asteroid> asteroidsIter = asteroids.iterator();
        while(asteroidsIter.hasNext()){
            Asteroid asteroid = asteroidsIter.next();
            if (asteroid.getPosition().y() < 0 || asteroid.getPosition().y() > app.height + 15
                    || asteroid.getPosition().x() < 0 || asteroid.getPosition().x() > app.width + 15) {
                asteroidsIter.remove();
                //uiController.deleteElement(asteroid.getVAsteroid());
                asteroid.kill();
            } else {
                asteroid.update();
            }
            //System.out.println(asteroid.getPosition().x() + " " + asteroid.getPosition().y());

        }
    }




}
