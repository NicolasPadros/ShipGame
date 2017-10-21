package edu.austral.view;

import edu.austral.util.Vector2;
import processing.core.PApplet;

import java.awt.*;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class VShot extends ViewPiece {
    private Vector2 direction;

    public VShot(PApplet parent, Vector2 position, Vector2 direction, Shape shape) {
        super(parent, position);
        this.direction = direction;
        this.shape = shape;

    }

    @Override
    public void collisionedWith(ViewPiece collisionable) {

    }

    @Override
    public void spawn() {

    }



    @Override
    public void destroy() {

    }


    public void draw(int x, int y) {

    }

    public void update() {}
}
