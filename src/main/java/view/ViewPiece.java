package view;

import edu.austral.util.Collisionable;
import edu.austral.util.Vector2;

import java.awt.*;

/**
 * Created by nicolas-p on 14/10/17.
 */
public abstract class ViewPiece implements Collisionable<ViewPiece>{

    private Shape shape;

    private Vector2 position;

    public abstract void spawn();

    public abstract void destroy();

    @Override
    public Shape getShape() {
        return shape;
    }
}
