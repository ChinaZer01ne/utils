package com.github.design.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 11:28
 */
public class CriteriaFemale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getGender().equalsIgnoreCase("FEMALE")){
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
