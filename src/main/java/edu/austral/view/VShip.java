package edu.austral.view;

import edu.austral.util.Vector2;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class VShip extends ViewPiece {
    private static PImage img;

    public VShip(PApplet parent, Vector2 position) {
        super(parent, position);
        img = parent.loadImage("resources/Spaceship.png");
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

    @Override
    public void draw(int x, int y) {
        parent.image(img, x, y, 40, 40);
    }

    @Override
    public void update() {

    }


    @Override
    public void destroy() {

    }
}
