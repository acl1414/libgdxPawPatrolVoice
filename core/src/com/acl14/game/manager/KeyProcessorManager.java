package com.acl14.game.manager;

import com.acl14.game.utils.GameConst;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;

public class KeyProcessorManager extends InputAdapter
{

    private static final int NUM_KEYS = 9;

    public static final int UP = 0;
    public static final int LEFT = 1;
    public static final int DOWN = 2;
    public static final int RIGHT = 3;
    public static final int ENTER = 4;
    public static final int ESCAPE = 5;
    public static final int SPACE = 6;
    public static final int SHIFT = 7;
    public static final int BACK = 8;

    private static boolean[] keys = new boolean[9];   // tableau contenant pour chaque touche un boolean indiquant si la touche est utilisée
    private static boolean[] pkeys = new boolean[9];  //le même que keys mais pour la previous key
    private static boolean ptouch;
    private static boolean touch;
    private static int touchScreenX;
    private static int touchScreenY;


    public boolean keyDown(int k){

        if (k==Keys.UP){
            KeyManager.setKey(KeyManager.UP, true);
        }
        if (k==Keys.LEFT){
            KeyManager.setKey(KeyManager.LEFT, true);
        }
        if (k==Keys.DOWN){
            KeyManager.setKey(KeyManager.DOWN, true);
        }
        if (k==Keys.RIGHT){
            KeyManager.setKey(KeyManager.RIGHT, true);
        }
        if (k==Keys.ENTER){
            KeyManager.setKey(KeyManager.ENTER, true);
        }
        if (k==Keys.ESCAPE){
            KeyManager.setKey(KeyManager.ESCAPE, true);
        }
        if (k==Keys.SPACE){
            KeyManager.setKey(KeyManager.SPACE, true);
        }
        if (k==Keys.SHIFT_LEFT || k==Keys.SHIFT_RIGHT){
            KeyManager.setKey(KeyManager.SHIFT, true);
        }
        if(k == Keys.BACK){
            KeyManager.setKey(KeyManager.BACK, true);
        }

        return true;
    }

    public boolean keyUp(int k){

        if (k== Keys.UP){
            KeyManager.setKey(KeyManager.UP, false);
        }
        if (k== Keys.DOWN){
            KeyManager.setKey(KeyManager.DOWN, false);
        }
        if (k== Keys.LEFT){
            KeyManager.setKey(KeyManager.LEFT, false);
        }
        if (k== Keys.RIGHT){
            KeyManager.setKey(KeyManager.RIGHT, false);
        }

        if (k==Keys.ENTER){
            KeyManager.setKey(KeyManager.ENTER, false);
        }
        if (k==Keys.ESCAPE){
            KeyManager.setKey(KeyManager.ESCAPE, false);
        }
        if (k==Keys.BACK){
            KeyManager.setKey(KeyManager.BACK, false);
        }

        return true;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button){

        KeyManager.setTouch(false, screenX, screenY);

        /*
        if (screenY<GameConst.HEIGHT/2)
        {
            KeyManager.setKey(KeyManager.UP, false);
        }
        else
        {
            KeyManager.setKey(KeyManager.DOWN, false);
        }

         */

        return true;
    }
    public boolean touchDown(int screenX, int screenY, int pointer, int button){

        KeyManager.setTouch(true, screenX, GameConst.HEIGHT-screenY);

        /*
        if (screenY<GameConst.HEIGHT/2){
            KeyManager.setKey(KeyManager.UP, true);
        }
        else {
            KeyManager.setKey(KeyManager.DOWN, true);
        }
*/
        return true;
    }

    public static float getTouchX()
    {
        return touchScreenX;
    }

    public static float getTouchY()
    {
        return touchScreenY;
    }

    public static boolean isDown(int paramInt)
    {
        return keys[paramInt];
    }

    public static boolean isPressed(int k){
        return keys[k] && !pkeys[k];
    }

    public static boolean isTouch()
    {
        return touch;
    }

    public static boolean isTouchPressed()
    {
        return (touch) && (!ptouch);
    }

    public static void setKey(int paramInt, boolean paramBoolean)
    {
        System.out.print(paramInt);
        keys[paramInt] = paramBoolean;
    }

    public static void setTouch(boolean paramBoolean, int paramInt1, int paramInt2)
    {
        touch = paramBoolean;
        touchScreenX = paramInt1;
        touchScreenY = paramInt2;
    }

    public static void update()
    {
        int i = 0;
        while (i < NUM_KEYS)
        {
            pkeys[i] = keys[i];
            i += 1;
        }
        ptouch = touch;
    }

    public static void clear()
    {// Efface toutes les valeurs stockées
        // System.out.println("KeyProcessorManager.clear()");
        int i = 0;
        while (i < NUM_KEYS)
        {
            keys[i] = false;
            pkeys[i] = false;
            i += 1;
        }
        touch = false;
        ptouch = false;
    }
}
