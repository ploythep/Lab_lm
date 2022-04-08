package com.ass.lmwn;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortPerson {

    public List<Person> sortByFirstNamethenLastName(List<Person> people) {
        return people.stream().sorted(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName)).toList();
    }


    public List<Person> filterByAge(List<Person> people) {
        return people.stream().filter(p -> p.getAge() >= 20).toList();
    }

    public Map<Person.Gender, List<Person>> groupByGender(List<Person> people) {
        return people
                .stream()
                .collect(
                        Collectors.groupingBy(Person::getGender));
    }
}
