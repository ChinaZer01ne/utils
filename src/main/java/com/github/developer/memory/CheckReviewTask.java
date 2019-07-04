package com.github.developer.memory;


import java.io.File;
import java.io.RandomAccessFile;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * 复习任务
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/2 17:17
 */
public class CheckReviewTask implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {

        List<MemoryRecord> reviewRecord = new ArrayList<>();

        RandomAccessFile accessFile = new RandomAccessFile(new File(MemoryConstant.FILE_PATH),"r");
        String line = null;

        while ((line = accessFile.readLine()) != null){
            String[] fields = line.split("\t");
            LocalDateTime reviewDateTime = LocalDateTime.parse(fields[1]);
            //当前分钟数
            int curMinute = LocalDateTime.now().getMinute();
            //复习次数
            int reviewCount = Integer.parseInt(fields[2]);
            int interval = MemoryConstant.REVIEW_INTERVAL[0];
            if (reviewCount > 0){
                //复习次数对应的间隔
                interval = MemoryConstant.REVIEW_INTERVAL[reviewCount] - MemoryConstant.REVIEW_INTERVAL[reviewCount - 1];
            }

            //如果上次复习时间距离当前时间大于复习次数对应的时间，那么该复习了
            if (curMinute - reviewDateTime.getMinute() > interval){
                reviewRecord.add(new MemoryRecord());
            }
        }

        return null;
    }
}
