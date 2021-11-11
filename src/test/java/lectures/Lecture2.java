package lectures;

import static org.assertj.core.api.Assertions.*;
import beans.Person;
import java.util.List;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

  @Test
  public void range() throws Exception {
    System.out.println("exclusive");
    IntStream.range(0, 10).forEach(System.out::println);
    System.out.println("inclusive");
    IntStream.rangeClosed(0, 10).forEach(System.out::println);
  }

  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();
    System.out.println("exclusive");
    IntStream.range(0, people.size()).mapToObj(i -> people.get(i)).forEach(System.out::println);
    System.out.println("inclusive");
    IntStream.rangeClosed(0, people.size()).mapToObj(i -> people.get(i))
        .forEach(System.out::println);
  }

  @Test
  public void intStreamIterate() throws Exception {
    IntStream.iterate(0, operand -> operand + 1)
        .filter(number -> number % 2 == 0)
        .limit(20)
        .forEach(System.out::println);
    assertThat(true).isTrue();
  }
}
