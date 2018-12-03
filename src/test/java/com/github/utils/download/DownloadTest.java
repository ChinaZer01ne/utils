package com.github.utils.download;

import org.springframework.util.DigestUtils;

/**
 * @Author: Zer01ne
 * @Date: 2018/12/3 12:47
 * @Version 1.0
 */
public class DownloadTest {
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5DigestAsHex(String.valueOf(System.currentTimeMillis()).getBytes()));
        DownloadFile.downloadCloudMusic("http://music.163.com/song/media/outer/url?id=453176145","listen");
        //DownloadFile.download("https://m10.music.126.net/20181203131558/0c76c5b852fe1e709e576163f55d93f4/ymusic/dd01/7af7/d70f/734cb3af28f5525f8b3a1454a5d73cdb.mp3");
    }
}
