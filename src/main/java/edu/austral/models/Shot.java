package edu.austral.models;

import edu.austral.util.Vector2;
import edu.austral.view.VShot;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class Shot {

    private Player player;

    private int damage;

    private Vector2 position;

    private Vector2 direction;

    public Shot(Player player, int damage) {
        this.player = player;
        this.damage = damage;
    }

    public void shooted() {
        //VShot.spawn(position, direction);

    }
}
