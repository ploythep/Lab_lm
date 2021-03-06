import com.ass.lmwn.Person;
import com.ass.lmwn.SortPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    public static List<Person> people;
    public static SortPerson sortPerson;

    @BeforeEach
    void setUp() {
        sortPerson = new SortPerson();
        people = Arrays.asList(new Person[]{
                new Person("Danny", "Armstrong", 12, Person.Gender.MALE),
                new Person("Beauty", "Clenton", 29, Person.Gender.FEMALE),
                new Person("Atom", "Doom", 33, Person.Gender.MALE),
                new Person("Cathy", "Banana", 18, Person.Gender.FEMALE),
                new Person("Danny", "Lee", 40, Person.Gender.FEMALE)
        });
    }

    @Test
    public void sortFristNameThenLastName() {
        List<Person> sortPeople = sortPerson.sortByFirstNamethenLastName(people);
        assertAll(() -> assertEquals("Atom", sortPeople.get(0).getFirstName()),
                () -> assertEquals("Beauty", sortPeople.get(1).getFirstName()),
                () -> assertEquals("Cathy", sortPeople.get(2).getFirstName()),
                () -> assertEquals("Danny", sortPeople.get(3).getFirstName()),
                () -> assertEquals("Danny", sortPeople.get(4).getFirstName())
        );
    }

    @Test
    public void selectPersonWhoHasAgeMoreThanTwenty() {
//        List<Person> filterPeople = sortPerson.filterByAge(people);
        Function<Integer,Predicate<Person>> filterAge = (ageOver) -> {
            return (person) -> person.getAge() > ageOver;
        };
        Predicate<Person> isAgeOverOrEquealToTwenty = filterAge.apply(20) ;
        List<Person> filterPeople = people.stream().filter(isAgeOverOrEquealToTwenty).toList();
        assertAll(() -> assertEquals(3, filterPeople.size()));
    }

    @Test
    public void groupByGender() {
        Map<Person.Gender, List<Person>> genderListMap = sortPerson.groupByGender(people);
        assertAll(() -> assertEquals(2, genderListMap.get(Person.Gender.MALE).size()),
                () -> assertEquals(3, genderListMap.get(Person.Gender.FEMALE).size())
        );
    }
}