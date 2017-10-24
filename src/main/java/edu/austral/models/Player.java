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
    private boolean alive = true;
    private float acummulatedVelocity;
    private float acummulatedRotation;

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
        this.livesCount = 5;
        this.ship.addPlayer(this);
        this.score = 50;
    }

    public List<Shot> shoot() {
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

    public void rotateLeft() {
        //this.move(-velocity, 0);
        this.ship.rotate(radians(-10));
        /*
        float angle = (degrees(this.ship.getDirection().angle()));
        if(angle <= 0){
            if(angle + 180 < rotationSpeed) this.ship.rotate(radians(angle + 180));
            else this.ship.rotate(radians(-rotationSpeed));
        }else {
            if(180 -angle < rotationSpeed) this.ship.rotate(radians((180 - angle)));
            else this.ship.rotate(radians(rotationSpeed));
        }

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


    public void rotateRight() {
        //this.move(velocity, 0);
        this.ship.rotate(radians(10));
        /*
        float angle = (degrees(this.ship.getDirection().angle()));
        if(angle <= 0){
            if(angle > -rotationSpeed) this.ship.rotate(radians(-angle));
            else this.ship.rotate(radians(rotationSpeed));
        }else {
            if(angle < rotationSpeed) this.ship.rotate(radians(-angle));
            else this.ship.rotate(radians(-rotationSpeed));
        }
        */
    }

    public void moveUp() {

        this.move(0, velocity);

    }

    public void moveDown() {
        this.move(0, -velocity);

    }

    public void rotate(float degrees){
        //this.ship.rotate(radians(degrees));
        acummulatedRotation += degrees;
    }

    public void addScore(int toAdd) {
        this.score += toAdd;

    }

    public int getScore() {
        return score;
    }

    public int getTag() {
        return tag;
    }

    public int getLives() {
        return livesCount;
    }

    public void loseLife(){
        if(livesCount == 0) {
            this.alive = false;
            return;
        }
        this.livesCount--;}

    public boolean isAlive() {
        return alive;
    }

    public void lose() {
        this.livesCount = 0;
    }

    public void update() {
        this.move(0, acummulatedVelocity);
        this.rotate(acummulatedRotation);
        acummulatedVelocity = 0;
        acummulatedRotation = 0;
    }

    public void accumulateVelocity(){
        this.acummulatedVelocity+=velocity;
    }

    public void decreaseAccumulatedVelocity(){
        this.acummulatedVelocity -=velocity;
    }

    public void accumulateRotation(float acummulatedRotation){
        this.acummulatedRotation += acummulatedRotation;
    }
}
