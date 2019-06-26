package com.github.basic;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
/**
 * 可以使用ReferenceQueue监控GC的发生
 */
public class ReferenceQueueTest {

    public static final ReferenceQueue<NormalObject> queue = new ReferenceQueue<>();

    public static void checkQueue(){
        Reference<NormalObject> ref = null;
        while ((ref = (Reference<NormalObject>) queue.poll()) != null){
            System.out.println("in queue " + ((NormalObjectWeakReference)  (ref)).name);
            System.out.println("reference object:" + ref.get());
        }
    }

    public static void main(String[] args) {

        ArrayList<WeakReference<NormalObject>> list= new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add(new NormalObjectWeakReference(new NormalObject("Weak " + i),queue));
            System.out.println("create weak: " + list.get(i));
        }

        System.out.println("first time");
        checkQueue();
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("second time");
        checkQueue();
    }
}



class NormalObject {
    public String name;
    public NormalObject(String name){
        this.name = name;
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize obj");
    }
}


class NormalObjectWeakReference extends WeakReference<NormalObject>{

    public String name;

    public NormalObjectWeakReference(NormalObject referent,ReferenceQueue<NormalObject> queue) {
        super(referent,queue);
        this.name = referent.name;
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalizing NormalObjectWeakReference " + name);
    }
}

