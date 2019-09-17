package com.github.concurrency;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicCasUpdaterTest {

    private volatile String name;

    public static void main(String[] args) {
        AtomicReferenceFieldUpdater<AtomicCasUpdaterTest,String> updater =
                AtomicReferenceFieldUpdater.newUpdater(AtomicCasUpdaterTest.class,String.class,"name");

        AtomicCasUpdaterTest obj = new AtomicCasUpdaterTest();
        obj.name = "old";
        updater.compareAndSet(obj,"old","new");
        System.out.println(obj.name);
    }
}
