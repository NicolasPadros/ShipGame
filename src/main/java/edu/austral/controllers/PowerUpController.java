package edu.austral.controllers;

import edu.austral.models.Asteroid;
import edu.austral.models.Gun;
import edu.austral.models.PowerUp;
import edu.austral.util.Vector2;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nicolas-p on 20/10/17.
 */
public class PowerUpController {

    private List<PowerUp> powerUps;

    public PowerUp createPowerUp(PApplet app, Vector2 position,
                                  Gun gun, float spawnTime) {
        PowerUp powerUp = new PowerUp(position, app, gun, spawnTime);
        powerUps.add(powerUp);
        return powerUp;
    }

    public PowerUpController() {
        this.powerUps = new ArrayList<>();
    }



    public void update(PApplet app, UIController uiController) {
        Iterator<PowerUp> powerUpIterator = powerUps.iterator();
        while(powerUpIterator.hasNext()){
            PowerUp powerUp = powerUpIterator.next();
            if (powerUp.getPosition().y() < 0 || powerUp.getPosition().y() > app.height + 15
                    || powerUp.getPosition().x() < 0 || powerUp.getPosition().x() > app.width + 15) {
                powerUpIterator.remove();
                //uiController.deleteElement(asteroid.getVAsteroid());
                powerUp.kill();
            } else {
                powerUp.update();
            }
            //System.out.println(asteroid.getPosition().x() + " " + asteroid.getPosition().y());

        }
    }

}
