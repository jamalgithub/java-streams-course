package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture12 {
  @Test
  public void understandingCollect() throws Exception {
    List<String> emails = MockData.getPeople()
        .stream()
        .map(Person::getEmail)
        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        //.collect(Collectors.toList());

    emails.forEach(System.out::println);
    assertThat(emails.size()).isEqualTo(1000);
  }
}
