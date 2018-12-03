package com.github.developer.cloudmusic;

import com.github.utils.download.DownloadFile;

import java.util.List;
import java.util.Map;

/**
 * @Author: Zer01ne
 * @Date: 2018/12/3 17:18
 * @Version 1.0
 */
public class CloudMusicDownloadTest {
    public static final String URL = "http://music.163.com/song/media/outer/url?id=";
    public static void main(String[] args) {
        CloudMusicParser cloudMusicParser = new CloudMusicParser();
        List<Map<String,Object>> list = cloudMusicParser.parserSongId("listen", "1", "0", "3");
        list.stream().forEach(map -> DownloadFile.downloadCloudMusic(URL + map.get("id"), map.get("name") + map.get("id").toString()));
    }
}
