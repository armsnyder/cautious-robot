package entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


/**
 * Template for any object that can be rendered and interacted with. All game entities should extend this class.
 */
public abstract class Entity {

    protected float x;
    protected float y;
    protected float width;
    protected float height;

    public Entity() {
        this(0, 0);
    }

    public Entity(float x, float y) {
        this(x, y, 0, 0);
    }

    public Entity(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void render(GameContainer container, StateBasedGame stateBasedGame, Graphics g)
            throws SlickException;

    public abstract void update(GameContainer container, StateBasedGame stateBasedGame, int i) throws SlickException;

    public boolean isOverlapping(Entity e) {
        return x <= e.x + e.width && x + width >= e.x && y <= e.y + e.height && y + height >= e.y;
    }

    public boolean contains(Entity e) {
        return x <= e.x && x + width >= e.x + e.width && y <= e.y && y + height >= e.y + e.height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
