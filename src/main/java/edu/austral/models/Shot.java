package edu.austral.models;

import edu.austral.util.Vector2;
import edu.austral.view.VShot;
import edu.austral.view.ViewPiece;
import processing.core.PApplet;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class Shot {

    private Player player;

    private int damage;

    private Vector2 position;

    private Vector2 direction;

    private VShot vShot;

    public Shot(Player player, int damage, Vector2 position, Vector2 direction,
                PApplet app) {
        this.player = player;
        this.damage = damage;
        this.position = position;
        this.direction = direction;
        this.vShot = new VShot(app, position, direction);
    }

    public void update() {
        this.position = this.position.$plus(direction);

    }

    public VShot getVShot() {
        return vShot;
    }
}
