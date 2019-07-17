package com.github.design.filter;

import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 11:27
 */
public interface Criteria {
    List<Person> meetCriteria(List<Person> persons);
}
