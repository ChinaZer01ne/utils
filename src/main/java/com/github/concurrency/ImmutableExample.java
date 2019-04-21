package com.github.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableExample {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> unmodifuable = Collections.unmodifiableList(list);
        list.set(1,5);
        unmodifuable.set(1,5);
        unmodifuable = list;
    }
}
