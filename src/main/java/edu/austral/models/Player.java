package edu.austral.models;

import edu.austral.view.ViewPiece;

import java.awt.event.KeyEvent;
import java.util.List;

import static processing.core.PApplet.degrees;
import static processing.core.PApplet.radians;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class Player {

    private List<Integer> controls;

    private int livesCount;

    private int score;

    private int tag;

    private int velocity;

    private Ship ship;

    public Player(List<Integer> controls, int tag, Ship ship) {
        this.controls = controls;
        this.tag = tag;
        this.ship = ship;
        this.velocity = 10;
    }

    public Player(int tag, Ship ship) {
        this.tag = tag;
        this.ship = ship;
        this.velocity = 10;
    }

    public Shot shoot() {
        return this.ship.shoot(this);
    }

    public void move(float x, float y) {
        this.ship.move(x, y);
        System.out.println(degrees(this.getShip().getDirection().angle()));

    }

    public void pause() {}

    public void start() {

    }

    public Ship getShip() {
        return ship;
    }

    public int getVelocity() {
        return velocity;
    }

    public void moveLeft() {
        this.move(-velocity, 0);
        this.ship.rotate(radians(10));
        /*
        float angle = degrees(this.ship.getDirection().angle());
        if(angle == 270 || angle == -90) return;
        if(angle >= 180){
            this.ship.rotate(radians(10));
            return;
        } else {
            this.ship.rotate(radians(-10));
            return;
        }
        */

    }


    public void moveRight() {
        this.move(velocity, 0);
        float angle = degrees(this.ship.getDirection().angle());
        if(angle == 90 || angle == -270) return;
        if(angle >= 180){
            this.ship.rotate(radians(10));
            return;
        } else {
            this.ship.rotate(radians(-10));
            return;
        }
    }

    public void moveUp() {
        this.move(0, -velocity);
        float angle = degrees(this.ship.getDirection().angle());
        if(angle == 0 || angle == -360) return;
        if(angle >= 180){
            this.ship.rotate(radians(10));
            return;
        } else {
            this.ship.rotate(radians(-10));
            return;
        }
    }

    public void moveDown() {
        this.move(0, velocity);
        float angle = degrees(this.ship.getDirection().angle());
        if(angle == 180 || angle == -180) return;
        if(angle >= 180){
            this.ship.rotate(radians(10));
            return;
        } else {
            this.ship.rotate(radians(-10));
            return;
        }
    }
}
