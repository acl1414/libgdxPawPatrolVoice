package com.acl14.game.state;

import com.acl14.game.manager.KeyManager;
import com.acl14.game.manager.StateManager;
import com.acl14.game.model.Badge;
import com.acl14.game.utils.FontGenerator;
import com.acl14.game.utils.GameConst;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class MainState extends State {



    private Texture backGround = new Texture(Gdx.files.internal("images/background.jpg"));
    private Texture libelle = new Texture(Gdx.files.internal("images/libelle.png"));
    private Texture buttonLeft = new Texture(Gdx.files.internal("images/left.png"));
    private Texture buttonRight = new Texture(Gdx.files.internal("images/right.png"));

    private GlyphLayout gameTitleLayout;
    private Rectangle gameTitleRectangle;
    private Rectangle buttonLeftRect;
    private Rectangle buttonRightRect;
    private Rectangle buttonPersoRect;

    private BitmapFont gameTitleText;

    private FreeTypeFontGenerator generator;
    private FreeTypeFontParameter parameter;

    private Sound selectedSound = null;
    private int selectSoundIndex = 0;        // index de l'item selectionné dans le menu
    private int selectBadgeIndex = 0;
    private Badge selectBadge = null;

    private List<Badge> badgeList = new ArrayList<Badge>();


    public MainState(StateManager paramGameStateManager)
    {
        super(paramGameStateManager);

        this.gameTitleText = FontGenerator.CreateFont(45, Color.WHITE,6, Color.BLACK, FontGenerator.FONT_ALAKITA);
        this.gameTitleLayout = FontGenerator.CreateLayout(this.gameTitleText,"Paw Patrol");

        Badge toAdd=null;
        int indexBadge = 0;

        toAdd= new Badge(Gdx.files.internal("images/badgePawPatrol.png"));
        toAdd.addSound(Gdx.audio.newSound(Gdx.files.internal("music/pawPatrol1.wav")));

        badgeList.add(indexBadge, toAdd);

        toAdd= new Badge(Gdx.files.internal("images/badgeRyder.png"));
        toAdd.addSound(Gdx.audio.newSound(Gdx.files.internal("music/ryder1.wav")));
        toAdd.addSound(Gdx.audio.newSound(Gdx.files.internal("music/ryder2.wav")));
        toAdd.addSound(Gdx.audio.newSound(Gdx.files.internal("music/ryder3.wav")));
        toAdd.addSound(Gdx.audio.newSound(Gdx.files.internal("music/ryder4.wav")));
        badgeList.add(++indexBadge, toAdd);

        toAdd= new Badge(Gdx.files.internal("images/badgeChase.png"));
        toAdd.addSound(Gdx.audio.newSound(Gdx.files.internal("music/chase1.wav")));
        toAdd.addSound(Gdx.audio.newSound(Gdx.files.internal("music/chase2.wav")));
        badgeList.add(++indexBadge,toAdd);

        toAdd= new Badge(Gdx.files.internal("images/badgeRuben.png"));
        toAdd.addSound(Gdx.audio.newSound(Gdx.files.internal("music/ruben1.wav")));
        toAdd.addSound(Gdx.audio.newSound(Gdx.files.internal("music/ruben2.wav")));
        badgeList.add(++indexBadge,toAdd);

        toAdd= new Badge(Gdx.files.internal("images/badgeMarcus.png"));
        toAdd.addSound(Gdx.audio.newSound(Gdx.files.internal("music/marcus1.wav")));
        toAdd.addSound(Gdx.audio.newSound(Gdx.files.internal("music/marcus2.wav")));
        badgeList.add(++indexBadge,toAdd);

        toAdd= new Badge(Gdx.files.internal("images/badgeZuma.png"));
        toAdd.addSound(Gdx.audio.newSound(Gdx.files.internal("music/zuma1.wav")));
        toAdd.addSound(Gdx.audio.newSound(Gdx.files.internal("music/zuma2.wav")));
        badgeList.add(++indexBadge,toAdd);

        toAdd= new Badge(Gdx.files.internal("images/badgeRocky.png"));
        toAdd.addSound(Gdx.audio.newSound(Gdx.files.internal("music/rocky1.wav")));
        toAdd.addSound(Gdx.audio.newSound(Gdx.files.internal("music/rocky2.wav")));
        badgeList.add(++indexBadge,toAdd);

        this.selectBadge=badgeList.get(0);

        this.calculateTextPosition();

    }

    private void calculateTextPosition(){

        // Création d'un rectangle correspondant au titre
        float titleRatio = (float) this.libelle.getHeight() / this.libelle.getWidth();
        int titleWidth = GameConst.WIDTH *9/10;
        int titleHeight = (int)(titleWidth * titleRatio);
        gameTitleRectangle = new Rectangle(GameConst.WIDTH / 2 - titleWidth / 2,GameConst.HEIGHT * 75 / 100 ,titleWidth,titleHeight);


        int buttonSize = GameConst.WIDTH /3; //les boutons sont carrés
        buttonLeftRect = new Rectangle(0,0,buttonSize,buttonSize);
        buttonRightRect = new Rectangle(GameConst.WIDTH- buttonSize,0,buttonSize,buttonSize);


        Badge badge = badgeList.get(0);
        float badgeRatio = (float) badge.getHeight() / badge.getWidth();
        int badgeWidth=GameConst.WIDTH * 8/10;
        int badgeHeight=(int)(badgeWidth*badgeRatio);
        buttonPersoRect = new Rectangle(GameConst.WIDTH/2-badgeWidth/2,GameConst.HEIGHT/2-badgeHeight/2 -GameConst.HEIGHT/25 ,badgeWidth,badgeHeight);
    }

    @Override
    public void update(float paramFloat) {


    }

    @Override
    public void render(float paramFloat, SpriteBatch sb) {

        sb.begin();

        // affichage du background
        sb.draw(this.backGround, 0.0F, 0.0F, GameConst.WIDTH, GameConst.HEIGHT);
        sb.draw(this.libelle, gameTitleRectangle.getX(), gameTitleRectangle.getY(), gameTitleRectangle.getWidth(), gameTitleRectangle.getHeight());

        // affichage button next et previous
        sb.draw(this.buttonLeft, buttonLeftRect.getX(), buttonLeftRect.getY(),buttonLeftRect.getWidth(),buttonLeftRect.getHeight());
        sb.draw(this.buttonRight, buttonRightRect.getX(), buttonRightRect.getY(),buttonRightRect.getWidth(),buttonRightRect.getHeight());


        // affichage du badge selectionné
        int index =0;
        for (Badge badge : this.badgeList){

            if (index == selectBadgeIndex){ // selectItemIndex contient le perso selectionné
                Texture perso = this.badgeList.get(index).getTexture();
                sb.draw(perso, buttonPersoRect.getX(), buttonPersoRect.getY(),buttonPersoRect.getWidth(),buttonPersoRect.getHeight());
            }


            index ++;
        }

        sb.end();

    }




    @Override
    public void handleInput() {

        if (KeyManager.isPressed(KeyManager.ENTER)) {
            selectSoundIndex = selectSoundIndex + 1;
            if (selectSoundIndex >= this.selectBadge.getNbSound()){
                selectSoundIndex = 0;
            }
            if (selectedSound !=null){ // stop current sound
                this.selectedSound.stop();
            }

            this.selectedSound=this.selectBadge.getSound(selectSoundIndex);
            this.selectedSound.play();
        }

        if (KeyManager.isPressed(KeyManager.RIGHT)) {
            selectBadgeIndex = selectBadgeIndex - 1;
            if (selectBadgeIndex < 0){
                selectBadgeIndex = badgeList.size()-1;
            }
            this.selectBadge = badgeList.get(selectBadgeIndex);
        }

        if (KeyManager.isPressed(KeyManager.LEFT)) {
            selectBadgeIndex = selectBadgeIndex + 1;
            if (selectBadgeIndex >= badgeList.size()){
                selectBadgeIndex = 0;
            }
            this.selectBadge = badgeList.get(selectBadgeIndex);
        }

        if (KeyManager.isTouchPressed()){

            if (buttonLeftRect.contains(KeyManager.getTouchX(),KeyManager.getTouchY())){
                selectBadgeIndex = selectBadgeIndex + 1;
                if (selectBadgeIndex >= badgeList.size()){
                    selectBadgeIndex = 0;
                }
                this.selectBadge = badgeList.get(selectBadgeIndex);
            }

            if (buttonRightRect.contains(KeyManager.getTouchX(),KeyManager.getTouchY())){
                selectBadgeIndex = selectBadgeIndex - 1;
                if (selectBadgeIndex < 0){
                    selectBadgeIndex = badgeList.size()-1;
                }
                this.selectBadge = badgeList.get(selectBadgeIndex);
            }

            if (buttonPersoRect.contains(KeyManager.getTouchX(),KeyManager.getTouchY())){
                selectSoundIndex = selectSoundIndex + 1;
                if (selectSoundIndex >= this.selectBadge.getNbSound()){
                    selectSoundIndex = 0;
                }
                if (selectedSound !=null){ // stop current sound
                    this.selectedSound.stop();
                }

                this.selectedSound=this.selectBadge.getSound(selectSoundIndex);
                this.selectedSound.play();
                
            }

        }

    }

    @Override
    public void dispose() {
        this.backGround.dispose();
        this.gameTitleText.dispose();

        for (Badge badge : badgeList){
            badge.dispose();
        }
    }


}
