package com.github.design.adapter;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 10:37
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
