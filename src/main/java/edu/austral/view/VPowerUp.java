package edu.austral.view;

import edu.austral.util.Vector2;
import processing.core.PApplet;

import java.awt.*;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class VPowerUp extends ViewPiece {


    @Override
    public Shape getShape() {
        return super.getShape();
    }

    @Override
    public void draw(int x, int y) {

    }


    public VPowerUp(PApplet parent, Vector2 position) {
        super(parent, position);
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
}
