package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

public class Lecture3 {

  @Test
  public void min() {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    Optional<Integer> min = numbers.stream().min((Integer::compare));
    min.ifPresent(System.out::println);
    assertThat(min.get()).isEqualTo(1);
  }

  @Test
  public void max() {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    Optional<Integer> max = numbers.stream().max(Comparator.naturalOrder());
    max.ifPresent(System.out::println);
    assertThat(max.get()).isEqualTo(100);
  }
}
