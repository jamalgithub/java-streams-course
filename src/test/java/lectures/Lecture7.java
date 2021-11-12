package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  @Test
  public void count() throws Exception {
    long count = MockData.getPeople().stream()
        .filter(p -> p.getGender().equalsIgnoreCase("female")).count();
    System.out.println(count);
    assertThat(count).isNotZero();
  }

  @Test
  public void min() throws Exception {
    List<Car> cars = MockData.getCars();
    double min = cars.stream().filter(car -> car.getColor().equalsIgnoreCase("yellow"))
        .mapToDouble(Car::getPrice).min().getAsDouble();
    System.out.println(min);
    assertThat(min).isEqualTo(6600.59);
  }

  @Test
  public void max() throws Exception {
    List<Car> cars = MockData.getCars();
    double min = cars.stream().filter(car -> car.getColor().equalsIgnoreCase("yellow"))
        .mapToDouble(Car::getPrice).max().getAsDouble();
    System.out.println(min);
    assertThat(min).isEqualTo(99677.14);
  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
    double average = cars.stream().mapToDouble(Car::getPrice).average().orElse(0);
    System.out.println(average);
    assertThat(average).isEqualTo(52693.19979);
  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
        .mapToDouble(Car::getPrice)
        .sum();
    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
    System.out.println(sum);
    System.out.println(bigDecimalSum);
    assertThat(sum).isEqualTo(5.269319979E7);
  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics = cars.stream()
        .mapToDouble(Car::getPrice)
        .summaryStatistics();
    System.out.println(statistics);
    System.out.println(statistics.getAverage());
    System.out.println(statistics.getCount());
    System.out.println(statistics.getMax());
    System.out.println(statistics.getMin());
    System.out.println(statistics.getSum());
    assertThat(statistics.getCount()).isEqualTo(1000L);
  }

}