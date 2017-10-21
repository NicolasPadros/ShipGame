package edu.austral.models;

/**
 * Created by nicolas-p on 21/10/17.
 */
public class Key {

    private int playerTag;

    private int keyCode;

    private String function;

    public Key(int playerTag, int keyCode, String function) {
        this.playerTag = playerTag;
        this.keyCode = keyCode;
        this.function = function;
    }

    public int getPlayerTag() {
        return playerTag;
    }

    public void setPlayerTag(int playerTag) {
        this.playerTag = playerTag;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
