package com.acl14.game.manager;

import com.acl14.game.state.MainState;
import com.acl14.game.state.State;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StateManager {

    public static final int STATE_MENU = 1;
    public static final int STATE_SOUND = 3;



    private State currentGameState;
    private SpriteBatch spriteBatch = new SpriteBatch();

    public StateManager() {
        this.setState(STATE_MENU);
    }

    public void update(float paramFloat) {

        this.currentGameState.update(paramFloat);
    }

    public void render(float paramFloat) {
        this.currentGameState.render(paramFloat, this.spriteBatch);
    }

    public void handleInput() {
        this.currentGameState.handleInput();
    }

    public void dispose() {
        this.currentGameState.dispose();
    }


    public void setState(int state) {
        KeyProcessorManager.clear();// On efface toutes les touches selctionnées (afin d'éviter action dès arrivé sur nouvel ecran)

        if (this.currentGameState != null) {
            this.currentGameState.dispose();
        }

         if (state == STATE_MENU) {
            this.currentGameState = new MainState(this);
        }


    }
}
