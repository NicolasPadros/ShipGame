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

    public ViewPiece(PApplet parent, Vector2 position) {
        this.parent = parent;
        this.position = position;
    }

    public abstract void spawn();

    public abstract void destroy();

    @Override
    public Shape getShape() {
        return shape;
    }

    public abstract void draw(int x, int y);


    public abstract void update();
}
