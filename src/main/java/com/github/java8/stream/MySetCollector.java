package com.github.java8.stream;

import org.apache.poi.ss.formula.functions.T;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
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
public class MySetCollector<T> implements Collector<T,Set<T>,Set<T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoke");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoke");
        return Set::add;
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {

        System.out.println("combiner invoke");

        return (set1,set2) ->{
            System.err.println("binaryOperator invoke");
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("finisher invoke");
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoke");
        //return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH,Characteristics.UNORDERED));
    }
}
