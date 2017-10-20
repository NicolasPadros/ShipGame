package edu.austral.controllers;

import edu.austral.models.Player;
import edu.austral.models.Ship;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by nicolas-p on 20/10/17.
 */
public class PlayerController {

    private List<Player> players;

    private Map<Player, List<Integer>> controls;


    public List<Player> getPlayers() {
        return players;
    }

    public Player createPlayer() {
        //only works for two players
        if(players.size() == 1) {
            List<Integer> controls = new ArrayList<>();
            controls.add(87);
            controls.add(65);
            controls.add(83);
            controls.add(68);
            controls.add(71);
            Player newPlayer = new Player(controls, 2, new Ship());
            players.add(newPlayer);
            return newPlayer;
        }
        List<Integer> controls = new ArrayList<>();
        controls.add(38);
        controls.add(37);
        controls.add(40);
        controls.add(39);
        controls.add(32);
        Player player = new Player(controls, 1, new Ship());
        players.add(player);
        return player;
    }
}
