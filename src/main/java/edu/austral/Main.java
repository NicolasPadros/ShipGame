package edu.austral;

import edu.austral.controllers.*;
import edu.austral.util.Vector2;
import processing.core.PApplet;
import edu.austral.view.VShip;

import java.awt.event.KeyEvent;

public class Main extends GameFramework {
    int x = 0;
    int y = 0;

    int gameState = 0;


    private GameController gameController;

    public static void main(String args[]) {
        PApplet.main("edu.austral.Main");
    }


    @Override public void draw(float time, PApplet graphics) {

        switch (gameState){
            case 0:
                gameController = new GameController(new AsteroidController(), new UIController(graphics),
                        new PlayerController(), new PowerUpController(), graphics);
                //gameController.start();
                gameState = 1;
                return;
            case 1:
               gameController.start();
                break;
            case 2:
                gameController.update();
                break;
            case 3:
                gameController.end();

                break;
            case 4:
                gameController.pause();
                break;
        }
        //VShip vship = new VShip(graphics, new Vector2(100, 10));
        //vship.draw(x, y);
        //ellipse(0, 0, 100, 100);

        gameState = gameController.getState();

    }



    @Override
    public void keyPressed(processing.event.KeyEvent event) {
        //super.keyPressed(event);
        //System.out.println(event.getKeyCode());
        gameState = gameController.keyPressed(event);
    }

    @Override
    public void keyReleased(processing.event.KeyEvent event) {
        gameController.keyReleased(event);
    }

    /*
    @Override
    public void keyPressed() {
        int i = 0;

        switch (key) {
                case 'w':
                    y-=10;
                    break;
                case 'a':
                    x-=10;
                    break;
                case 's':
                    y+=10;
                    break;
                case 'd':
                    x+=10;
                    break;
            }
        draw();

    }
    */



    @Override
    public void setup() {
        background(51);
        frameRate(30);
        width = 500;
        height = 500;
    }
}
