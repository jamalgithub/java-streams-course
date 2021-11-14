package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String join = "";
    for (String name : names) {
      join += name + ", ";
    }
    join = join.substring(0, join.length() - 2);
    System.out.println(join);
    assertThat(join).isNotEmpty();
  }

  @Test
  public void joiningStringsWithStream() {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String join = names.stream().collect(Collectors.joining(","));
    System.out.println(join);
    assertThat(join).isEqualTo("anna,john,marcos,helena,yasmin");
  }
}
