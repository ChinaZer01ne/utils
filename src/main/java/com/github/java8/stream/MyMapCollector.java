package com.github.java8.stream;

import org.apache.poi.ss.formula.functions.T;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/15 11:47
 */
public class MyMapCollector<T> implements Collector<T,Map<T,T>,Map<T,T>> {

    @Override
    public Supplier<Map<T, T>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<T, T>, T> accumulator() {

        return (theMap,str) -> {
            theMap.put(str,str);
        };
    }

    @Override
    public BinaryOperator<Map<T, T>> combiner() {
        return (theMap,map) -> {
            theMap.putAll(map);
            return theMap;
        };
    }

    @Override
    public Function<Map<T, T>, Map<T, T>> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }
}
