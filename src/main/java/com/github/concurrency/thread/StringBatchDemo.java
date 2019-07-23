package com.github.concurrency.thread;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/23 10:59
 */
public class StringBatchDemo {
    public static void main(String[] args) {

        Integer count = 7000000;

        StringEntity strs = createString();

        //printStr(strs,count);

        long start = System.nanoTime();
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(()->{
            printStr(strs,count / 2);
        });
        service.submit(()->{
            printStr(strs,count / 2);
        });
        System.err.println(System.nanoTime() - start);

    }

    private static void printStr(StringEntity strs,Integer count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(Thread.currentThread().getName());
            stringBuilder.append("[");
            stringBuilder.append(Optional.ofNullable(strs.getWord1()).orElse(" "));
            stringBuilder.append(" ");
            stringBuilder.append(Optional.ofNullable(strs.getWord2()).orElse(" "));
            stringBuilder.append(" ");
            stringBuilder.append(Optional.ofNullable(strs.getWord3()).orElse(" "));
            stringBuilder.append(" ");
            stringBuilder.append(Optional.ofNullable(strs.getWord4()).orElse(" "));
            stringBuilder.append(" ");
            stringBuilder.append(Optional.ofNullable(strs.getWord5()).orElse(" "));
            stringBuilder.append(Optional.ofNullable(strs.getWord6()).orElse(" "));
            stringBuilder.append("]");
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    private static StringEntity createString() {
        return new StringEntity("This","is","a","test","string",null);
    }
    private static class StringEntity{
        private String word1;
        private String word2;
        private String word3;
        private String word4;
        private String word5;
        private String word6;

        public StringEntity(String word1, String word2, String word3, String word4, String word5, String word6) {
            this.word1 = word1;
            this.word2 = word2;
            this.word3 = word3;
            this.word4 = word4;
            this.word5 = word5;
            this.word6 = word6;
        }

        public String getWord1() {
            return word1;
        }

        public void setWord1(String word1) {
            this.word1 = word1;
        }

        public String getWord2() {
            return word2;
        }

        public void setWord2(String word2) {
            this.word2 = word2;
        }

        public String getWord3() {
            return word3;
        }

        public void setWord3(String word3) {
            this.word3 = word3;
        }

        public String getWord4() {
            return word4;
        }

        public void setWord4(String word4) {
            this.word4 = word4;
        }

        public String getWord5() {
            return word5;
        }

        public void setWord5(String word5) {
            this.word5 = word5;
        }

        public String getWord6() {
            return word6;
        }

        public void setWord6(String word6) {
            this.word6 = word6;
        }
    }
}
