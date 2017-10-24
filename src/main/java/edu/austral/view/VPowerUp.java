package edu.austral.view;

import edu.austral.models.Gun;
import edu.austral.util.Vector2;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class VPowerUp extends ViewPiece {


    private final Vector2 direction;

    private static PImage img;
    private final Gun gun;

    public Gun getGun() {
        return gun;
    }

    @Override
    public Shape getShape() {
        return super.getShape();
    }


    public void draw(int x, int y) {

    }

    @Override
    public void update() {
        if (this.alive) {

            this.position = this.position.$plus(direction);

            if (this.position.y() < 0 || this.position.y() > parent.height + 15) {
                this.destroy();
                return;
            }
            parent.image(img, this.position.x(), this.position.y(), 40, 40);
            this.shape = new Ellipse2D.Float(position.x(), position.y(), 40, 40);
        } else {
            System.out.println("dead");
        }

    }


    public VPowerUp(PApplet parent, Vector2 position, Vector2 direction, Gun gun) {
        super(parent, position);
        this.direction = direction;
        this.gun = gun;
        this.shape = new Ellipse2D.Double(position.x(), position.y(), 40, 40);
    }

    @Override
    public void collisionedWith(ViewPiece collisionable) {
        if(collisionable instanceof VShip){
            this.destroy();

        }
    }

    @Override
    public void spawn() {
        img = parent.loadImage("resources/powerUp.png");
        parent.image(img, position.x(), position.y(), 40, 40);
    }


}
