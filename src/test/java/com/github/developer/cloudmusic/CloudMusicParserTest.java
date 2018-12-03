package com.github.developer.cloudmusic;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: Zer01ne
 * @Date: 2018/12/3 15:11
 * @Version 1.0
 */
public class CloudMusicParserTest {

    public static void main(String[] args) {
        CloudMusicParser cloudMusicParser = new CloudMusicParser();
        cloudMusicParser.parserSongId("listen","1","0","10");
    }
}
