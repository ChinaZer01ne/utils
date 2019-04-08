package com.github.java8.function;

import java.util.*;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/8 14:48
 */
public class OptionalTest2 {

    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setUsername("peach");
        Employee employee2 = new Employee();
        employee2.setUsername("lion");

        Company company = new Company();
        company.setName("ali");

        List<Employee> employees = Arrays.asList(employee,employee2);
        //company.setList(employees);



        Optional<List<Employee>> optional = Optional.ofNullable(company.getList());
        //如果optional不为空返回原集合，如果为空返回空集合
        List<Employee> employeesOfCpmpany = optional.orElse(new ArrayList<>());
        System.out.println(employeesOfCpmpany);

        Optional<Company> optional2 = Optional.ofNullable(company);
        System.out.println(optional2.map(Company::getList).orElse(Collections.emptyList()));
    }
}
