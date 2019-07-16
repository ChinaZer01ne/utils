package com.github.design.template;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 16:24
 */
public abstract class Game {

    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
