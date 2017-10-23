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

    private int rotationSpeed;

    public Player(List<Integer> controls, int tag, Ship ship) {
        this.controls = controls;
        this.tag = tag;
        this.ship = ship;
        this.velocity = 10;
        this.rotationSpeed = 20;
    }

    public Player(int tag, Ship ship) {
        this.tag = tag;
        this.ship = ship;
        this.velocity = 10;
        this.rotationSpeed = 20;
    }

    public Shot shoot() {
        return this.ship.shoot(this);
    }

    public void move(float x, float y) {
        this.ship.move(x, y);
        //System.out.println(degrees(this.getShip().getDirection().angle()));

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
        float angle = (degrees(this.ship.getDirection().angle()));
        if(angle <= 0){
            if(angle + 180 < rotationSpeed) this.ship.rotate(radians(angle + 180));
            else this.ship.rotate(radians(-rotationSpeed));
        }else {
            if(180 -angle < rotationSpeed) this.ship.rotate(radians((180 - angle)));
            else this.ship.rotate(radians(rotationSpeed));
        }
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
        float angle = (degrees(this.ship.getDirection().angle()));
        if(angle <= 0){
            if(angle > -rotationSpeed) this.ship.rotate(radians(-angle));
            else this.ship.rotate(radians(rotationSpeed));
        }else {
            if(angle < rotationSpeed) this.ship.rotate(radians(-angle));
            else this.ship.rotate(radians(-rotationSpeed));
        }
    }

    public void moveUp() {
        this.move(0, -velocity);
        float angle = degrees(this.ship.getDirection().angle());
        if(Math.abs(angle) <= 90){
            if(angle + 90 < rotationSpeed) this.ship.rotate(radians(angle + 90));
            else this.ship.rotate(radians(-rotationSpeed));
        } else {
            if(angle + 90 < -rotationSpeed) this.ship.rotate(radians(90 + angle));
            else this.ship.rotate(radians(rotationSpeed));
        }
    }

    public void moveDown() {
        this.move(0, velocity);
        float angle = degrees(this.ship.getDirection().angle());
        if(Math.abs(angle) <= 90){
            if(90 - angle < rotationSpeed) this.ship.rotate(radians(90 -angle));
            else this.ship.rotate(radians(rotationSpeed));
        } else {
            if(angle - 90 < rotationSpeed) this.ship.rotate(radians(angle - 90));
            else this.ship.rotate(radians(-rotationSpeed));
        }
    }

    public void addScore(int toAdd) {
        this.score += toAdd;

    }
}
