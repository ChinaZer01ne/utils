package com.github.io.other;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/9/5 14:52
 */
public class ChannalTest {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\jdk-11.0.2_windows-x64_bin.exe");
        RandomAccessFile accessFile = new RandomAccessFile(file,"rw");
        FileChannel channel = accessFile.getChannel();
        System.out.println(channel.size());

        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        //HeapByteBuffer
        //DirectByteBuffer



    }
}
