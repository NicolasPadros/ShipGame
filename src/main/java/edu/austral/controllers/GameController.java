package edu.austral.controllers;

import edu.austral.models.Asteroid;
import edu.austral.models.Player;
import edu.austral.util.Vector2;
import processing.core.PApplet;

import java.util.List;

/**
 * Created by nicolas-p on 20/10/17.
 */
public class GameController {

    private PApplet app;
    private AsteroidController asteroidController;

    private UIController uiController;

    private PlayerController playerController;

    private PowerUpController powerUpController;

    public GameController(AsteroidController asteroidController, UIController uiController,
                          PlayerController playerController, PowerUpController powerUpController,
                          PApplet parent) {
        this.asteroidController = asteroidController;
        this.uiController = uiController;
        this.playerController = playerController;
        this.powerUpController = powerUpController;
        this.app = parent;
    }

    public GameController(AsteroidController asteroidController, UIController uiController, PlayerController playerController, PowerUpController powerUpController) {
        this.asteroidController = asteroidController;
        this.uiController = uiController;
        this.playerController = playerController;
        this.powerUpController = powerUpController;
        app = null;
    }

    public void init() {
    }

    public void start() {
        /*
       List<Player> players =  playerController.getPlayers();
        for (Player player : players) {
            uiController.addElement(player.getShip().getVShip());
        }
        */
        uiController.addElement(asteroidController.createAsteroid(app, new Vector2(100, 100)).getVAsteroid());
       //uiController.start();
        //this.update();
    }

    public void addPlayer() {

    }

    public void pause() {}

    public void end(){}

    public void setup() {}

    public void update(PApplet app) {
        this.app = app;
        /*
        if(app.frameCount % 100 == 0){
            Asteroid newAst = asteroidController.createAsteroid(app,
                    new Vector2((float)Math.random() * 1000, (float)Math.random() * 1000));
            uiController.addElement(newAst.getVAsteroid());
        }
        */
        asteroidController.update(app);
        //uiController.update();
    }
}
