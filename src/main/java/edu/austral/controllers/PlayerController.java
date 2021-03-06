package edu.austral.controllers;

import edu.austral.models.Key;
import edu.austral.models.Player;
import edu.austral.models.Ship;
import edu.austral.models.Shot;
import edu.austral.util.Vector2;
import processing.core.PApplet;
import processing.event.KeyEvent;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by nicolas-p on 20/10/17.
 */
public class PlayerController {

    private List<Player> players;

    //finds Player by tag
    private List<Key> controls;


    public PlayerController() {
        players = new ArrayList<>();
        controls = new ArrayList<>();
    }


    public List<Player> getPlayers() {
        return players;
    }

    public Player createPlayer(PApplet app) {
        //only works for two players
        if(players.size() == 1) {
            Key up = new Key(1, 87, "moveU");
            Key left = new Key(1, 65, "moveL");
            Key down = new Key(1, 83, "moveD");
            Key right = new Key(1, 68, "moveR");
            Key shoot = new Key(1, 71, "shoot");

            controls.add(up);
            controls.add(left);
            controls.add(down);
            controls.add(right);
            controls.add(shoot);
            Ship two = new Ship("two", new Vector2(200, 200), app);
            Player newPlayer = new Player(1, two);
            players.add(newPlayer);
            return newPlayer;
        }
        Key up = new Key(0, 38, "moveU");
        Key left = new Key(0, 37, "moveL");
        Key down = new Key(0, 40, "moveD");
        Key right = new Key(0, 39, "moveR");
        Key shoot = new Key(0, 32, "shoot");

        controls.add(up);
        controls.add(left);
        controls.add(down);
        controls.add(right);
        controls.add(shoot);
        Ship one = new Ship("one", new Vector2(250, 250), app);
        Player player = new Player( 0, one);
        players.add(player);
        return player;
    }

    //returns optional if the key was for shooting
    public Optional<List<Shot>> receiveKey(KeyEvent event) {
        int code = event.getKeyCode();
        for (Key control : controls) {
            if(control.getKeyCode() == code){
                String toDo = control.getFunction();
                Player player = players.get(control.getPlayerTag());
                switch (toDo){
                    case "shoot":
                        return Optional.of(player.shoot());
                    case "moveL":
                        player.rotateLeft();
                        break;
                    case "moveR":
                        player.rotateRight();
                        break;
                    case "moveU":
                        player.moveForward();
                        break;
                    case "moveD":
                        player.moveBackwards();
                        break;
                }
            }
        }

        return Optional.empty();
    }




    public boolean checkLives() {
        for (Player player : players) {
            if(!player.isAlive()) return true;
        }
        return false;
    }

}
