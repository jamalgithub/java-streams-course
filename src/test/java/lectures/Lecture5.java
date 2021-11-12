package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    List<Car> carList = cars.stream().filter(car -> car.getPrice() < 10000)
        .collect(Collectors.toList());
    carList.stream().forEach(System.out::println);
    assertThat(carList).isNotEmpty();
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    List<PersonDTO> personDTOS = people.stream().map(PersonDTO::map).collect(Collectors.toList());
    personDTOS.stream().forEach(System.out::println);
    assertThat(personDTOS).isNotEmpty();
  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    ImmutableList<Car> cars = MockData.getCars();
    double average = cars.stream().mapToDouble(car -> car.getPrice()).average().orElse(0);
    System.out.println(average);
    assertThat(average).isNotZero();
  }

  @Test
  public void test() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    cars.forEach(System.out::println);
    assertThat(cars.size()).isEqualTo(1000);
  }
}



