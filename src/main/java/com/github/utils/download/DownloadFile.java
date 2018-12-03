package com.github.utils.download;

import java.io.*;
import java.net.*;

/**
 * @Author: Zer01ne
 * @Date: 2018/12/3 12:33
 * @Version 1.0
 */
public class DownloadFile {


    public static void download(String url){
        download(url,null);
    }

    public static void download(String url, String fileName){
        //从网络读
        InputStream inputStream = null;
        //读缓冲
        BufferedInputStream bufferedInputStream = null;
        //写到本地
        FileOutputStream outputStream = null;
        try {
            // 开启连接
            HttpURLConnection conn = prepareConnection(url);

            // 建立实际的连接
            conn.connect();
            // 获取流
            inputStream = conn.getInputStream();

            bufferedInputStream = new BufferedInputStream(inputStream);
            if (fileName == null){
                outputStream = new FileOutputStream("d:\\music\\1.mp3");
            }else {
                outputStream = new FileOutputStream("d:\\music\\"+fileName+".mp3");
            }

            //文件大小
            int fileLength = conn.getContentLength();
            //下载
            doDownload(bufferedInputStream, outputStream, fileLength);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           closeConnection(inputStream, bufferedInputStream, outputStream);
        }

    }




    /**网易云音乐下载*/
    public static void downloadCloudMusic(String url, String fileName){
        HttpURLConnection connection = prepareConnection(url);
        // 设置通用的请求属性.模拟浏览器客户端
        connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

        //网易云下载页面有个跳转，获取跳转之后的url
        connection.setInstanceFollowRedirects(false);
        try {
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取跳转之后的url
        String realUrl = connection.getHeaderField("Location");
        //下载音乐
        download(realUrl,fileName);
    }

    private static void doDownload(InputStream inputStream, OutputStream outputStream, int fileLength) throws IOException {
        int size = 0;
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((size = inputStream.read(buffer)) != -1){
            len += size;
            outputStream.write(buffer, 0 ,size);
            // 打印下载百分比
             System.out.println("下载了-------> " + len * 100 / fileLength + "%\n");
        }
    }



    private static HttpURLConnection  prepareConnection(String url){

        try {
            URL fileUrl = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection)fileUrl.openConnection();

            return urlConnection;
        }catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void closeConnection(InputStream inputStream,  BufferedInputStream bufferedInputStream, FileOutputStream outputStream){
        try {
            if (outputStream != null){
                outputStream.close();
            }
            if (bufferedInputStream != null){
                bufferedInputStream.close();
            }
            if (inputStream != null){
                inputStream.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
