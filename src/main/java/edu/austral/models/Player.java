package edu.austral.models;

import edu.austral.view.ViewPiece;

import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class Player {

    private List<Integer> controls;

    private int livesCount;

    private int score;

    private int tag;

    private Ship ship;

    public Player(List<Integer> controls, int tag, Ship ship) {
        this.controls = controls;
        this.tag = tag;
        this.ship = ship;
    }

    public void shoot() {
    }

    public void move() {}

    public void pause() {}

    public void start() {

    }

    public Ship getShip() {
        return ship;
    }
}
