package com.github.developer.cloudmusic;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Zer01ne
 * @Date: 2018/12/3 15:11
 * @Version 1.0
 */
public class CloudMusicParser {

    /**网易云搜索api*/
    //private static final String SEARCH_URL= "http://music.163.com/api/search/get/web?s=listen&type=1&offset=0&total=true&limit=100";
    private static final String SEARCH_URL_PART1 = "http://music.163.com/api/search/get/web?s=";
    private static final String SEARCH_URL_PART2 = "&type=";
    private static final String SEARCH_URL_PART3 = "&offset=";
    private static final String SEARCH_URL_PART4 = "&total=true&limit=";
    /**
     * @param key : 搜过关键字
     * @param type : 搜索类型
     *             单曲：1   歌手：100  专辑：10  视频：1014  歌词：1006  歌单：1000  主播电台：1009  用户：1002
     * @param offset : 起始页
     * @param limit : 每页大小
     * @return java.util.List
     * @throws
     */
    @SuppressWarnings({"unchecked"})
    public List<Map<String,Object>> parserSongId(String key, String type, String offset, String limit){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(stringBuilder.append(SEARCH_URL_PART1).append(key)
                    .append(SEARCH_URL_PART2).append(type)
                    .append(SEARCH_URL_PART3).append(offset)
                    .append(SEARCH_URL_PART4).append(limit).toString());
            //清空
            stringBuilder.delete(0,stringBuilder.length());

            URLConnection urlConnection = url.openConnection();
            //网易云需要模拟浏览器请求，才能请求导数据
            urlConnection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //urlConnection.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null){
                stringBuilder.append(line);
            }
            //每一页的歌曲相关信息
            Map map = JSONObject.parseObject(stringBuilder.toString(),Map.class);
            map = (Map) map.get("result");
            if (map != null){
                List<Map> songs = (List) map.get("songs");
                ArrayList resultlist = new ArrayList();
                Map<String, Object> collect = null;
                for (Map songMap:
                        songs) {
                    collect = new HashMap(4);
                    //保存id
                    collect.put("id",songMap.get("id"));
                    //保存歌名
                    collect.put("name",songMap.get("name"));
                    //保存歌手
                    if (songMap.get("artists") != null){
                        List<Map> artists = (List) songMap.get("artists");
                        if (artists.size() > 1){

                            stringBuilder.delete(0,stringBuilder.length());
                            for (int i = 0; i < artists.size(); i++) {

                                stringBuilder.append(artists.get(i).get("name"));
                                if (i != artists.size() - 1){
                                    stringBuilder.append("/");
                                }
                            }
                            collect.put("artists",stringBuilder.toString());
                        }else if (artists.size() == 0){
                            collect.put("artists","未知歌手");
                        }else {
                            collect.put("artists",artists.get(0).get("name"));
                        }


                    }
                    //保存专辑名称
                    if (songMap.get("album") != null){
                        collect.put("album",((Map)songMap.get("album")).get("name"));
                    }


                    resultlist.add(collect);
                }
                //System.out.println(list);
                return resultlist;
            }


        }catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList();
    }
}
