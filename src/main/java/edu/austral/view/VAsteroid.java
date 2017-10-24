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

    private int life;

    public VAsteroid(PApplet app, Vector2 position, Vector2 direction, int life) {
        super(app, position);
        this.direction = direction;
        this.shape = new Ellipse2D.Double(position.x(), position.y(), 40, 40);
        this.life = life;
    }

    public static PImage getImg() {
        return img;
    }

    @Override
    public void collisionedWith(ViewPiece collisionable) {
        if(collisionable instanceof VShot){
            this.life -= ((VShot)collisionable).getDamage();

        }
    }

    @Override
    public void spawn() {
        img = parent.loadImage("resources/asteroid.png");
        parent.image(img, position.x(), position.y(), 40, 40);
    }



    public void update() {
        if (life > 0) {

            this.position = this.position.$plus(direction);

            if (checkBoundaries()) {
                this.destroy();
                return;
            }
            parent.image(img, this.position.x(), this.position.y(), 40, 40);
            this.shape = new Ellipse2D.Float(position.x(), position.y(), 40, 40);
        } else {
            this.alive = false;
        }
    }


}
