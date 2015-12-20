package state;

import entity.ExampleEntity;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Basic game state
 */
public class ExampleState extends MasterState {

    public static final int ID = 0;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        ExampleEntity exampleEntity = new ExampleEntity(); // Create new game object
        container.getInput().addKeyListener(exampleEntity); // Allow game object to receive keyboard input
        registerEntity(exampleEntity, 0); // Add game object to update/render cycle on layer 0
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        super.update(container, game, delta);
    }
}
