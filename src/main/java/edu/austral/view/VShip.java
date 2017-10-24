package edu.austral.view;

import edu.austral.models.Player;
import edu.austral.models.Ship;
import edu.austral.util.Vector2;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import static processing.core.PConstants.CENTER;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class VShip extends ViewPiece {
    private static PImage img;
    private final Ship ship;
    private Vector2 direction;
    private Player player;

    private int timeCollapse = 100;
    private int lastCollision;
    public VShip(PApplet parent, Vector2 position, Ship ship) {
        super(parent, position);
        img = parent.loadImage("resources/Spaceship.png");
        this.direction = new Vector2(0, -1);
        this.shape = new Ellipse2D.Double(position.x(), position.y(), 40, 40);
        this.ship = ship;

    }

    public static PImage getImg() {
        return img;
    }

    @Override
    public void collisionedWith(ViewPiece collisionable) {
        if(collisionable instanceof VPowerUp){
            this.ship.upgradeGun(((VPowerUp)(collisionable)).getGun());
            return;
        } else if (collisionable instanceof VAsteroid){
            if(parent.millis() - lastCollision < timeCollapse) return;
            this.player.loseLife();
            this.lastCollision = parent.millis();
        }

    }

    @Override
    public void spawn() {
        parent.image(img, position.x(), position.y(), 20, 20);
    }


    public void draw(float x, float y) {
        this.position = new Vector2(x, y);
        //this.update();
    }

    public void rotate(float angle) {
        this.direction = this.direction.rotate(angle);

        //this.update();

    }
    @Override
    public void update() {
        if (this.position.y() < 0 || this.position.y() > parent.height + 15) {
            this.destroy();
            this.player.lose();
            return;
        }
        parent.pushMatrix();
        parent.imageMode(CENTER);
        parent.translate(this.position.x(), this.position.y());
        parent.rotate(this.direction.angle() + PConstants.HALF_PI);
        this.shape = new Ellipse2D.Float(position.x(), position.y(), 40, 40);
        //parent.image(img, position.x(), position.y(), 40, 40);
        parent.image(img, 0, 0, 40, 40);
        parent.popMatrix();
    }


    @Override
    public void destroy() {
    }

    public PApplet getApp() {
        return parent;
    }

    public void addPlayer(Player player) {
        this.player = player;
    }
}
