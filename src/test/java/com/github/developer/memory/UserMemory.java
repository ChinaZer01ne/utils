package com.github.developer.memory;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 命令行
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/2 17:20
 */
public class UserMemory {

    public void writeStudyItem(List<MemoryRecord> memoryRecords) throws IOException {
        for (MemoryRecord record:
                memoryRecords) {
            System.out.println(String.format("在%s添加了%s\n", record.getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),record.getItem()));
        }

        File file = new File(MemoryConstant.FILE_PATH);


        if (!file.exists()){
            if (!file.createNewFile()){
                throw new FileNotFoundException();
            }
        }

        RandomAccessFile accessFile = new RandomAccessFile(file,MemoryConstant.FILE_MODE);
        accessFile.seek(accessFile.length());
        FileChannel fileChannel = accessFile.getChannel();

        StringBuilder stringBuilder = new StringBuilder();
        for (MemoryRecord record:
                memoryRecords) {
            stringBuilder.append(record.getId());
            stringBuilder.append(MemoryConstant.TAB_CHAR);
            stringBuilder.append(record.getLocalDateTime().format(MemoryConstant.DATE_TIME_FORMATTER));
            stringBuilder.append(MemoryConstant.TAB_CHAR);
            stringBuilder.append(record.getItem());
            stringBuilder.append(MemoryConstant.LINE_SEPARATOR);
        }


        ByteBuffer buffer = ByteBuffer.wrap(stringBuilder.toString().getBytes());
        int write = fileChannel.write(buffer);
        fileChannel.close();
        System.out.println("写入字节数量：" + write);
    }

    public List<MemoryRecord> readStudyItem() throws IOException {

        List<MemoryRecord> items = new ArrayList<>();

        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);

             BufferedReader reader = new BufferedReader(inputStreamReader)) {

            System.out.println("今天又学习了什么东西呢？");

            String item = reader.readLine();
            MemoryRecord memoryRecord = null;
            while (!"q".equals(item) && !"Q".equals(item) ){
                memoryRecord = new MemoryRecord();
                memoryRecord.setItem(item);
                memoryRecord.setLocalDateTime(LocalDateTime.now());
                items.add(memoryRecord);
                System.out.println("还有吗？");
                item = reader.readLine();
            }

        }
        return items;
    }
}
