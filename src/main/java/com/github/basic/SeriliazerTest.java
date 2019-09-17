package com.github.basic;

import java.io.*;

public class SeriliazerTest implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        writeObj();
        readObj();
    }

    private static void readObj() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("./obj,dat")));
        Object o = objectInputStream.readObject();
        SeriliazerObj obj = (SeriliazerObj) o;
        System.out.println(obj);
    }
    private static void writeObj() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("./obj,dat")));
        SeriliazerObj seriliazerObj = new SeriliazerTest().new SeriliazerObj();
        seriliazerObj.setScore(1);
        seriliazerObj.setName("lion");
        seriliazerObj.setMessage("xxx");
        objectOutputStream.writeObject(seriliazerObj);
    }

    class SeriliazerObj implements Serializable {
        private int score;
        private String name;
        private transient String message;

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "SeriliazerObj{" +
                    "score=" + score +
                    ", name='" + name + '\'' +
                    ", message='" + message + '\'' +
                    '}';
        }

        private void writeObject(java.io.ObjectOutputStream s)
                throws java.io.IOException {
            s.defaultWriteObject();
            System.out.println("竟然会执行这个write？");
        }
        private void readObject(java.io.ObjectInputStream s)
                throws java.io.IOException, ClassNotFoundException {
            s.defaultReadObject();
            System.out.println("竟然会执行这个read？");
        }

    }
}
