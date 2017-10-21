package edu.austral.view;

import edu.austral.util.Vector2;
import processing.core.PApplet;
import processing.core.PImage;

import static processing.core.PConstants.CENTER;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class VShip extends ViewPiece {
    private static PImage img;
    private Vector2 direction;

    public VShip(PApplet parent, Vector2 position) {
        super(parent, position);
        img = parent.loadImage("resources/Spaceship.png");
        this.direction = new Vector2(1, 0);
    }

    public static PImage getImg() {
        return img;
    }

    @Override
    public void collisionedWith(ViewPiece collisionable) {

    }

    @Override
    public void spawn() {
        parent.image(img, position.x(), position.y(), 40, 40);
    }


    public void draw(float x, float y) {
        this.position = new Vector2(x, y);
        //this.update();
    }

    public void rotate(float angle) {
        this.direction = this.direction.rotate(angle);

        //this.update();

    }
    @Override
    public void update() {

        parent.pushMatrix();
        parent.imageMode(CENTER);
        parent.translate(this.position.x(), this.position.y());
        parent.rotate(this.direction.angle());
        //parent.image(img, position.x(), position.y(), 40, 40);
        parent.image(img, 0, 0, 40, 40);
        parent.popMatrix();
    }


    @Override
    public void destroy() {
    }
}
