package edu.austral;

import edu.austral.util.Vector2;
import processing.core.PApplet;
import edu.austral.view.VShip;

import java.awt.event.KeyEvent;

public class Main extends GameFramework {
    int x = 0;
    int y = 0;
    public static void main(String args[]) {
        PApplet.main("edu.austral.Main");
    }


    @Override public void draw(float time, PApplet graphics) {
        VShip vship = new VShip(graphics, new Vector2(100, 10));
        vship.draw(x, y);
        //ellipse(0, 0, 100, 100);

    }

    @Override public void keyPressed(KeyEvent event) {
    }

    @Override
    public void keyPressed() {
        System.out.println("hola");
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



    @Override
    public void setup() {
    }
}
