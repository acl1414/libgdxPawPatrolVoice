package com.acl14.game.state;

import com.acl14.game.manager.StateManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State
{
    protected StateManager gsm;

    protected State(StateManager paramGameStateManager)
    {
        this.gsm = paramGameStateManager;
    }

    public abstract void update(float paramFloat);
    public abstract void render(float paramFloat, SpriteBatch paramSpriteBatch);
    public abstract void handleInput();
    public abstract void dispose();
}