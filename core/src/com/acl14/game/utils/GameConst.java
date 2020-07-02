package com.acl14.game.utils;

import com.badlogic.gdx.Gdx;

public class GameConst {

    public static final float ECHELLE_H = 1.0F;
    public static final String GAME_TITLE = "HUGO RAPIDO";
    public static final float GRAVITY = -0.5F;
    public static int HEIGHT = 0;
    public static int NB_LEVEL = 15;
    public static int NB_TILE_X = 0;
    public static int NB_TILE_Y = 0;
    public static final int PLAYER_HEIGHT = 128;
    public static final int PLAYER_WIDTH = 64;
    public static final float SPEED_SCROLING = 0.25F;
    public static final int TILE_SIZE = 32;
    public static final int TIME_BEFORE_RESPAWN = 5;
    public static final int VIEWPORT_HEIGHT = 1280;
    public static final int VIEWPORT_WIDTH = 768;
    public static int WIDTH = 0;

   public static final int WINDOW_HEIGHT = 900;
    public static final int WINDOW_WIDTH = 1500;

    public GameConst()
    {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        NB_TILE_X = WIDTH / TILE_SIZE;
        NB_TILE_Y = HEIGHT / TILE_SIZE;
    }
}
