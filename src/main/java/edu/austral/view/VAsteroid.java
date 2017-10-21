package edu.austral.view;

import edu.austral.util.Vector2;
import javafx.scene.shape.Circle;
import processing.core.PApplet;
import processing.core.PImage;


/**
 * Created by nicolas-p on 14/10/17.
 */
public class VAsteroid extends ViewPiece {

    private final Vector2 direction;

    private static PImage img;

    public VAsteroid(PApplet app, Vector2 position, Vector2 direction) {
        super(app, position);
        this.direction = direction;
    }

    public static PImage getImg() {
        return img;
    }

    @Override
    public void collisionedWith(ViewPiece collisionable) {

    }

    @Override
    public void spawn() {
        img = parent.loadImage("resources/asteroid.png");
        parent.image(img, position.x(), position.y(), 40, 40);
    }




    public void draw(int x, int y) {

    }

    public void update() {

        this.position = this.position.$plus(direction);

        if (this.position.y() < 0 || this.position.y() > parent.height + 15) {
            this.destroy();
        }
        parent.image(img, this.position.x(), this.position.y(), 40, 40);
    }

    public void update(PApplet app) {
        this.parent = app;
        this.update();
    }
}
