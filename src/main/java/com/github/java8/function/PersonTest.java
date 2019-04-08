package com.github.java8.function;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/8 11:17
 */
public class PersonTest {
    public static void main(String[] args) {

        Person person1 = new Person("peach",20);
        Person person2 = new Person("apple",30);
        Person person3 = new Person("pear",40);

        List<Person> list = Arrays.asList(person1,person2,person3);

        List<Person> apples = getPersonByUsername(list, "apple");

        apples.forEach(System.out::println);

        System.out.println("===============================");
        List<Person> personByAge = getPersonByAge(list, 20);

        personByAge.forEach(System.out::println);

        System.out.println("===============================");

        List<Person> personByAge2 = getPersonByAge2(list, 20,(personList,ageArg) -> {
            return personList.stream().filter(person -> person.getAge() > ageArg).collect(Collectors.toList());
        });

        personByAge2.forEach(System.out::println);
    }

    public static List<Person> getPersonByUsername(List<Person> persons, String username){
        return persons.stream().filter(person -> Objects.equals(username,person.getUsername())).collect(Collectors.toList());
    }

    public static List<Person> getPersonByAge(List<Person> persons, int age){

        BiFunction<List<Person>,Integer,List<Person>> biFunction = (personList,ageArg) -> {
            return personList.stream().filter(person -> Objects.equals(ageArg,person.getAge())).collect(Collectors.toList());
        };

        return biFunction.apply(persons,age);
    }

    public static List<Person> getPersonByAge2(List<Person> persons, int age, BiFunction<List<Person>,Integer,List<Person>> biFunction){


        return biFunction.apply(persons,age);
    }
}
