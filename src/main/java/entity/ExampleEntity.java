package entity;

import asset.Images;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 * An example of an entity that has an animation.
 */
public class ExampleEntity extends Entity implements KeyListener {

    private static final int SPEED = 5;

    private Animation defaultAnimation;
    private int deltaX = 0;
    private int deltaY = 0;

    public ExampleEntity() {
        super();
        defaultAnimation = new Animation(Images.exampleSpriteSheet, 100);
    }

    @Override
    public void render(GameContainer container, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        defaultAnimation.draw(x, y);
    }

    @Override
    public void update(GameContainer container, StateBasedGame stateBasedGame, int i) throws SlickException {
        defaultAnimation.update(i);
        x += deltaX*SPEED;
        y += deltaY*SPEED;
    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Keyboard.KEY_UP) deltaY += -1;
        if (key == Keyboard.KEY_DOWN) deltaY += 1;
        if (key == Keyboard.KEY_LEFT) deltaX += -1;
        if (key == Keyboard.KEY_RIGHT) deltaX += 1;
    }

    @Override
    public void keyReleased(int key, char c) {
        if (key == Keyboard.KEY_UP) deltaY += 1;
        if (key == Keyboard.KEY_DOWN) deltaY += -1;
        if (key == Keyboard.KEY_LEFT) deltaX += 1;
        if (key == Keyboard.KEY_RIGHT) deltaX += -1;
    }

    @Override
    public void setInput(Input input) {
    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {

    }

    @Override
    public void inputStarted() {

    }
}
