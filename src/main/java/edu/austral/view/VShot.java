package edu.austral.view;

import edu.austral.models.Asteroid;
import edu.austral.models.Player;
import edu.austral.util.Vector2;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;

import java.awt.geom.Ellipse2D;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class VShot extends ViewPiece {

    private Vector2 direction;

    private PShape pShape;

    private Player player;
    private int damage;

    public VShot(PApplet parent, Vector2 position, Vector2 direction, Player pLayer, int damage) {
        super(parent, position);
        this.direction = direction;
        this.player = pLayer;
        this.pShape = parent.createShape(PConstants.ELLIPSE, this.position.x(), this.position.y(), 10, 10);
        this.shape = new Ellipse2D.Float(position.x(), position.y(), 10, 10);
        this.damage = damage;
    }

    @Override
    public void collisionedWith(ViewPiece collisionable) {
        if(collisionable instanceof VAsteroid) {
            player.addScore(10);
            this.alive = false;
        }

    }

    @Override
    public void spawn() {
        parent.shape(pShape);

    }




    public void update() {
        this.position = this.position.$plus(direction);

        if (checkBoundaries()) {
            this.destroy();
        }
        parent.ellipse(this.position.x(), this.position.y(), 10, 10);
        this.shape = new Ellipse2D.Float(position.x(), position.y(), 10, 10);
        //parent.pShape(pShape, this.position.x(), this.position.y(), 10, 10);

    }



    public int getDamage() {
        return damage;
    }
}
