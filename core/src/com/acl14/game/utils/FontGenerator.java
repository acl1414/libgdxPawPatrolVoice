package com.acl14.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public final class FontGenerator {

    public final static String FONT_PACIFICO="fonts/Pacifico.ttf";
    public final static String FONT_ALAKITA="fonts/Alakita.ttf";
    public final static String FONT_CHRISTMAS="fonts/Waving at Christmas.ttf";
    private FreeTypeFontGenerator generator;

    public static BitmapFont CreateFont() {
        return CreateFont(21, Color.BLACK, FONT_PACIFICO);
    }

    public static BitmapFont CreateFont(int size, Color color) {
        return CreateFont(size, color, FONT_PACIFICO);
    }

    public static BitmapFont CreateFont(int size, Color color, String pathFont) {

        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.size = size;
        param.color= color;

        return CreateFont(param,pathFont);
    }
    public static BitmapFont CreateFont(int size, Color color,int borderSize, Color borderColor, String pathFont) {

        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.size = size;
        param.color= color;
        param.borderColor=borderColor;
        param.borderWidth=borderSize;

        return CreateFont(param,pathFont);
    }

    public static BitmapFont CreateFont(FreeTypeFontGenerator.FreeTypeFontParameter param, String pathFont) {
        BitmapFont result = null;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(pathFont));

        result = generator.generateFont(param);

        return result;
    }





    public static GlyphLayout CreateLayout(BitmapFont font, String text){
        GlyphLayout result = new GlyphLayout();
        result.setText(font, text);
        return result;
    }



}
