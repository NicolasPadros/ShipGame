package edu.austral.view;

import edu.austral.util.Collisionable;
import edu.austral.util.Vector2;
import processing.core.PApplet;


import java.awt.*;

/**
 * Created by nicolas-p on 14/10/17.
 */
public abstract class ViewPiece implements Collisionable<ViewPiece>{

    protected Shape shape;

    protected Vector2 position;

    protected PApplet parent;

    protected boolean alive;

    public ViewPiece(PApplet parent, Vector2 position) {
        this.parent = parent;
        this.position = position;
        this.alive = true;
    }

    public abstract void spawn();

    public void destroy() {
        this.alive = false;
    }

    @Override
    public Shape getShape() {
        return shape;
    }




    public abstract void update();

    public boolean isAlive() {
        return alive;
    }
}
