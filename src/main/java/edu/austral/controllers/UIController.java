package edu.austral.controllers;

import edu.austral.models.Asteroid;
import edu.austral.util.CollisionEngine;
import edu.austral.view.VAsteroid;
import edu.austral.view.VShot;
import edu.austral.view.ViewPiece;
import processing.core.PApplet;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nicolas-p on 20/10/17.
 */
public class UIController {

    private float delta;

    private List<ViewPiece> elementsInScreen;

    public void pause() {}

    public void showStartUp() {}

    public void start() {


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

    public UIController() {
        this.elementsInScreen = new ArrayList<>();
        delta = 10;
    }

    public void deleteElement(ViewPiece element) {
        this.elementsInScreen.remove(element);
        element.destroy();
    }
}
