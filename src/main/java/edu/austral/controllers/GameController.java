package edu.austral.controllers;

import edu.austral.models.Asteroid;
import edu.austral.models.Player;
import edu.austral.models.Shot;
import edu.austral.util.Vector2;
import processing.core.PApplet;
import processing.event.KeyEvent;


import java.util.List;
import java.util.Optional;

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
        //uiController.addElement(asteroidController.createAsteroid(app, new Vector2(100, 100)).getVAsteroid());
        this.addPlayer();
       //uiController.start();
        //this.update();
    }

    public void addPlayer() {
        uiController.addElement(playerController.createPlayer(app).getShip().getVShip());
    }

    public void pause() {}

    public void end(){}

    public void setup() {}

    public void update() {


        if(app.frameCount % 100 == 0){
            Asteroid newAst = asteroidController.createAsteroid(app,
                    new Vector2((float)Math.random() * app.width, (float)Math.random() * app.height));
            uiController.addElement(newAst.getVAsteroid());
        }


        asteroidController.update(app, uiController);

        uiController.update();
    }

    public void keyPressed(KeyEvent event) {
        Optional<Shot> optional = playerController.receiveKey(event);
        optional.ifPresent(shot -> uiController.addElement(shot.getVShot()));
    }
}
