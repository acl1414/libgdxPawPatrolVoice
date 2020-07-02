package com.acl14.game;

import com.acl14.game.manager.KeyManager;
import com.acl14.game.manager.KeyProcessorManager;
import com.acl14.game.manager.StateManager;
import com.acl14.game.utils.GameConst;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LaunchGame extends ApplicationAdapter {
	private StateManager gsm;

	public void create()
	{
		new GameConst();
		this.gsm = new StateManager();
		Gdx.input.setInputProcessor(new KeyProcessorManager());
		Gdx.input.setCatchBackKey(true);
	}

	public void dispose()
	{
		this.gsm.dispose();
	}

	public void render()
	{
		Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
		Gdx.gl.glClear(16384);
		float dt = Gdx.graphics.getDeltaTime();
		this.gsm.update(dt);
		this.gsm.render(dt);
		this.gsm.handleInput();
		KeyManager.update();
	}
}
