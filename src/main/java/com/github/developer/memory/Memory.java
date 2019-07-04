package com.github.developer.memory;

import java.io.IOException;
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
        //service.s
    }


}
