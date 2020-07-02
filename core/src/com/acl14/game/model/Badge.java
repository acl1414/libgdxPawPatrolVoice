package com.acl14.game.model;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

public class Badge {

    private Texture texture=null;
    private List<Sound> soundList = new ArrayList<Sound>();

    public Badge(FileHandle file){
        this.texture=new Texture(file);
    }

    public void addSound(Sound sound){
        this.soundList.add(sound);
    }

    public Sound getSound(int index){
        Sound result = null;

        result=this.soundList.get(index);

        return result;
    }

    public int getNbSound(){
        return this.soundList.size();
    }

    public Texture getTexture(){
        return this.texture;
    }

    public int getWidth(){
        return this.texture.getWidth();
    }
    public int getHeight(){
        return this.texture.getHeight();
    }

    public void dispose(){
        this.texture.dispose();
        for (Sound sound : soundList){
            sound.dispose();
        }

    }

}
