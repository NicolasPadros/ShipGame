package edu.austral.view;

import edu.austral.util.Vector2;
import javafx.scene.shape.Circle;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.geom.Ellipse2D;


/**
 * Created by nicolas-p on 14/10/17.
 */
public class VAsteroid extends ViewPiece {

    private final Vector2 direction;

    private static PImage img;

    public VAsteroid(PApplet app, Vector2 position, Vector2 direction) {
        super(app, position);
        this.direction = direction;
        this.shape = new Ellipse2D.Double(position.x(), position.y(), 40, 40);
    }

    public static PImage getImg() {
        return img;
    }

    @Override
    public void collisionedWith(ViewPiece collisionable) {
        if(collisionable instanceof VShot){
            this.destroy();
        }
    }

    @Override
    public void spawn() {
        img = parent.loadImage("resources/asteroid.png");
        parent.image(img, position.x(), position.y(), 40, 40);
    }




    public void draw(int x, int y) {

    }

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

    public void update(PApplet app) {
        this.parent = app;
        this.update();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
