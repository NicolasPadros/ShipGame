package edu.austral.controllers;

import edu.austral.models.Asteroid;
import edu.austral.models.Player;
import edu.austral.util.CollisionEngine;
import edu.austral.view.VAsteroid;
import edu.austral.view.VShot;
import edu.austral.view.ViewPiece;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nicolas-p on 20/10/17.
 */
public class UIController {

    private final PApplet app;
    private final PFont p;
    private float delta;

    private PFont pTitle;



    private List<ViewPiece> elementsInScreen;

    public void pause() {}

    public void showStartUp() {
        this.app.fill(255);
        this.app.textFont(pTitle);
        this.app.text("Press Space for one player or Enter for two", this.app.width/2, this.app.height/2);
    }


    public void showMenu() {}

    public void end() {}

    public void update() {
        Iterator<ViewPiece> iterator = elementsInScreen.iterator();
        while(iterator.hasNext()){
            ViewPiece viewPiece = iterator.next();
            if(!viewPiece.isAlive()) {
                iterator.remove();
            } else viewPiece.update();
        }

        CollisionEngine<ViewPiece> engine = new CollisionEngine<>();
        engine.checkCollisions(elementsInScreen);
    }



    public void addElement(ViewPiece element) {
        elementsInScreen.add(element);
        element.spawn();
    }

    public UIController(PApplet app) {
        this.elementsInScreen = new ArrayList<>();
        this.app = app;
        this.pTitle = this.app.createFont("Arial", 22, true);
        this.p = this.app.createFont("Arial", 11, true);
        this.app.textAlign(PConstants.CENTER);
    }

    public void deleteElement(ViewPiece element) {
        this.elementsInScreen.remove(element);
        element.destroy();
    }

    public void updateText(List<Player> players) {
        int xCoord = 40;
        int yCoord = 20;
        this.app.textFont(p);
        for (Player player : players) {
            app.text("Player "  + (player.getTag() + 1),xCoord, yCoord );
            app.text("Score: " + player.getScore(), xCoord, yCoord += 20);
            app.text("Lives: " + player.getLives(), xCoord, yCoord + 20);
            xCoord += app.width/2;
            yCoord = 20;
        }
    }

    public void showEndScreen(){
        this.app.fill(255);
        this.app.textFont(pTitle);
        this.app.text("Game over!", this.app.width/2, this.app.height/2);
    }

    public void showPause() {
        this.app.fill(255);
        this.app.textFont(pTitle);
        this.app.text("Pause", this.app.width/2, this.app.height/2);
    }
}
