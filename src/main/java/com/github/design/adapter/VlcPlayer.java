package com.github.design.adapter;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 10:34
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
