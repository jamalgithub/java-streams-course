package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class Lecture10 {

  private static final List<ArrayList<String>> arrayListOfNames = Lists.newArrayList(
      Lists.newArrayList("Mariam", "Alex", "Ismail"),
      Lists.newArrayList("John", "Alesha", "Andre"),
      Lists.newArrayList("Susy", "Ali")
  );

  @Before
  public void setUp() {
    System.out.println(arrayListOfNames);
  }

  @Test
  public void withoutFlatMap() {
//    [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
    List<String> names = org.assertj.core.util.Lists.newArrayList();
    for (List<String> listOfNames : arrayListOfNames) {
      Collections.addAll(listOfNames);
    }
    System.out.println(names);
    assertThat(names).isNotEmpty();

  }

  @Test
  public void withFlatMap() throws Exception {
//   [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
    List<String> flatMap = arrayListOfNames.stream().flatMap(List::stream)
        .collect(Collectors.toList());
    System.out.println(flatMap);
    assertThat(flatMap).isNotEmpty();
  }

}

