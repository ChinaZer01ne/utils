package com.github.java8.stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/15 11:11
 */
public class MySetCollector2<T> implements Collector<T,Set<T>,Map<T,T>> {


    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoke");
        return () -> {
            System.out.println("supplier init");
            return new HashSet<T>();
        };
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoke");
        return (set,e) ->{
            System.out.println("accumulator " + set + ", " + Thread.currentThread().getName());
            set.add(e);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoke");
        return (set1,set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoke");
        return (set) ->{
            Map<T,T> map = new HashMap<>();
            set.forEach(e -> map.put(e,e));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoke");
        //return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED,Characteristics.CONCURRENT));
        //return Collections.unmodifiableSet(Collections.emptySet());
    }


    public static void main(String[] args) {

        for (int i = 0; i < 1; i++) {
            List<String> list = Arrays.asList("peach","world","hello","welcome","lion");
            Set<String> set = new HashSet<>();
            set.addAll(list);

            System.out.println(set.parallelStream().collect(new MySetCollector2<>()));
        }

    }
}
