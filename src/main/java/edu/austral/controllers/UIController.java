package edu.austral.controllers;

import edu.austral.view.VAsteroid;
import edu.austral.view.VShot;
import edu.austral.view.ViewPiece;

import java.util.ArrayList;
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
        for (ViewPiece viewPiece : elementsInScreen) {
                viewPiece.update();
            }

        }


    public void addElement(ViewPiece element) {
        elementsInScreen.add(element);
        element.spawn();
    }

    public UIController() {
        this.elementsInScreen = new ArrayList<>();
        delta = 10;
    }
}
