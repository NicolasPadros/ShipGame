package edu.austral.controllers;

import edu.austral.models.*;
import edu.austral.util.Vector2;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.event.KeyEvent;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static javafx.scene.input.KeyCode.P;
import static javafx.scene.input.KeyCode.SPACE;
import static processing.core.PApplet.radians;
import static processing.core.PConstants.ENTER;
import static processing.core.PConstants.ESC;

/**
 * Created by nicolas-p on 20/10/17.
 */
public class GameController {

    private PApplet app;
    private AsteroidController asteroidController;

    private UIController uiController;

    private PlayerController playerController;

    private PowerUpController powerUpController;

    private int players;

    private int generalScore;
    private int prevScoreAux;

    private int state;

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
        this.state = 1;
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

        state = 1;


       uiController.showStartUp();
       if(this.players != 0) {
           this.state = 2;
           for (int i = 0; i < players; i++) {
               uiController.addElement(playerController.createPlayer(app).getShip().getVShip());
           }
       }
        //this.update();
    }

    public void addPlayer() {
        uiController.addElement(playerController.createPlayer(app).getShip().getVShip());
    }

    public void pause() {

        this.uiController.showPause();}

    public void end(){
        this.uiController.showEndScreen();
    }


    public void update() {
        generalScore = 0;
        List<Player> players = playerController.getPlayers();
        for (Player player : players) {
            generalScore += player.getScore();
        }


        if(generalScore-prevScoreAux >= 50 && generalScore != 0) {
             System.out.println(generalScore);
            Vector2 initPosition = playerController.getPlayers().get(0).getShip().getPosition();
            //Vector2 initPosition = new Vector2((float)Math.random() * app.width, (float)Math.random() * app.height);
            List<Vector2> directions = new ArrayList<>();
            Vector2 direct1 = new Vector2(0, -1);
            directions.add(direct1);
            directions.add(direct1.rotate(radians(45)));
            directions.add(direct1.rotate(radians(-45)));
            Gun gun = new Gun(50, 1, directions);
            PowerUp powerUp = powerUpController.createPowerUp(app, initPosition, gun, 1
                    );
            uiController.addElement(powerUp.getVPowerUp());
            prevScoreAux = generalScore;

        }

        if(app.frameCount % 100 == 0){
            Asteroid newAst = asteroidController.createAsteroid(app);
            uiController.addElement(newAst.getVAsteroid());
        }


        asteroidController.update(app, uiController);

        uiController.update();
        uiController.updateText(players);
        if(playerController.checkLifes()) state = 3;
                else state = 2;
    }

    public int keyPressed(KeyEvent event) {
        if(state == 1){
            if(event.getKey() == 32) players = 1;
            else if (event.getKey() == ENTER) players = 2;
            return state;
        }
        if(state == 2) {
            if(event.getKey() == 'p'){
                this.pause();
                this.state = 4;
                return state;
            }
            else {
                Optional<List<Shot>> optional = playerController.receiveKey(event);
                if (optional.isPresent()) {
                    List<Shot> shots = optional.get();
                    for (Shot shot : shots) {
                        uiController.addElement(shot.getVShot());
                    }
                }
                return state;
            }
        } else if(state == 3){
            if(event.getKey() == 'r') {
                this.state = 0;
                return state;
            }
        } else if (state == 4){
            if(event.getKey() == 'p'){
                this.state = 2;
                return state;
            }
        }
        return state;
    }

    public void keyReleased(KeyEvent event) {
        uiController.update();
    }

    public int getState() {
        return state;
    }
}
