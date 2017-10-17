package edu.austral.models;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class Shot {

    private Player player;

    private int damage;

    public Shot(Player player, int damage) {
        this.player = player;
        this.damage = damage;
    }
}
