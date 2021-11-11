package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.junit.Test;

public class Lecture4 {

  @Test
  public void distinct() {
    final List<Integer> numbers = ImmutableList
        .of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
    List<Integer> numbersDistinct = numbers.stream().distinct().collect(Collectors.toList());
    System.out.println(numbersDistinct);
    assertThat(numbersDistinct).isNotEmpty();
  }

  @Test
  public void distinctWithSet() {
    final List<Integer> numbers = ImmutableList
        .of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
    Set<Integer> numbersDistinct = numbers.stream().collect(Collectors.toSet());
    System.out.println(numbersDistinct);
    assertThat(numbersDistinct).isNotEmpty();
  }
}
