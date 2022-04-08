import com.ass.lmwn.Person;
import com.ass.lmwn.SortByName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    public static List<Person> people;
    public static SortByName sortByName;

    @BeforeEach
    void setUp() {
        sortByName = new SortByName();
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
        people = sortByName.sortByFirstNamethenLastName(people);
        assertAll(() -> assertEquals("Atom", people.get(0).getFirstName()),
                () -> assertEquals("Beauty", people.get(1).getFirstName()),
                () -> assertEquals("Cathy", people.get(2).getFirstName()),
                () -> assertEquals("Danny", people.get(3).getFirstName()),
                () -> assertEquals("Danny", people.get(4).getFirstName())
        );
    }


}