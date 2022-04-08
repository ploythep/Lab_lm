package com.ass.lmwn;

import java.util.Comparator;
import java.util.List;

public class SortPerson implements Comparator<Person> {

    public List<Person> sortByFirstNamethenLastName(List<Person> people) {
        return people.stream().sorted(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName)).toList();
    }

    @Override
    public int compare(Person o1, Person o2) {
        return 0;
    }


}
