package edu.austral.view;

import edu.austral.util.Vector2;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;

import java.awt.*;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class VShot extends ViewPiece {

    private Vector2 direction;

    private PShape shape;

    public VShot(PApplet parent, Vector2 position, Vector2 direction) {
        super(parent, position);
        this.direction = direction;
        this.shape = parent.createShape(PConstants.ELLIPSE, this.position.x(), this.position.y(), 10, 10);
        //this.shape = shape;

    }

    @Override
    public void collisionedWith(ViewPiece collisionable) {

    }

    @Override
    public void spawn() {
        parent.shape(shape);

    }



    @Override
    public void destroy() {

    }


    public void draw(int x, int y) {

    }

    public void update() {
        this.position = this.position.$plus(direction);

        if (this.position.y() < 0 || this.position.y() > parent.height + 15) {
            this.destroy();
        }
        parent.ellipse(this.position.x(), this.position.y(), 10, 10);
        //parent.shape(shape, this.position.x(), this.position.y(), 10, 10);

    }
}
