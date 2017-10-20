package edu.austral.models;

import edu.austral.util.Vector2;
import edu.austral.view.VGun;

import java.util.List;

/**
 * Created by nicolas-p on 14/10/17.
 */
public class Gun {

    private int munition;

    private float firingRate;

    private Shot bulletShot;

    private List<Vector2> typeOfShot;

    private VGun viewGun;

    public int getMunition() {
        return munition;
    }

    public void shoot() {


    }
}
