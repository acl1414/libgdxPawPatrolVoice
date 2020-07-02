package com.acl14.game.manager;

public class KeyManager {


    private static final int NUM_KEYS = 9;

    public static final int BACK = 8;
    public static final int DOWN = 2;
    public static final int ENTER = 4;
    public static final int ESCAPE = 5;
    public static final int LEFT = 1;
    public static final int RIGHT = 3;
    public static final int SHIFT = 7;
    public static final int SPACE = 6;
    public static final int UP = 0;

    private static boolean[] keys = new boolean[9];
    private static boolean[] pkeys = new boolean[9];
    private static boolean ptouch;
    private static boolean touch;
    private static int touchScreenX;
    private static int touchScreenY;

    public static void clear()
    {
        int i = 0;
        while (i < 9)
        {
            keys[i] = false;
            pkeys[i] = false;
            i += 1;
        }
        ptouch = touch;
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

    public static boolean isPressed(int paramInt)
    {
        return (keys[paramInt] != false) && (pkeys[paramInt] == false);
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
        keys[paramInt] = paramBoolean;
    }

    public static void setTouch(boolean paramBoolean, int paramInt1, int paramInt2)
    {
        //System.out.println("setTouchDown2="+paramBoolean);
        touch = paramBoolean;
        touchScreenX = paramInt1;
        touchScreenY = paramInt2;
    }

    public static void update()
    {
        int i = 0;
        while (i < 9)
        {
            pkeys[i] = keys[i];
            i += 1;
        }
        ptouch = touch;
    }
}
