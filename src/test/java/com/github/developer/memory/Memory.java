package com.github.developer.memory;

import io.netty.buffer.ByteBuf;
import org.testng.collections.CollectionUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/2 15:32
 */
public class Memory {




    public static void main(String[] args) throws IOException {

        UserMemory userMemory = new UserMemory();
        List<MemoryRecord> memoryRecords = userMemory.readStudyItem();
        userMemory.writeStudyItem(memoryRecords);

        ExecutorService service = Executors.newScheduledThreadPool(1);
        service.s
    }


}
