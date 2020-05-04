package investing;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeLevelGraphTest {

  @Test
  public void build() {
      float[] input = {100,105,107};
      float[] expected = {100,105,107};
      final float[] actual = ThreeLevelGraph.build(input);
      assertArrayEquals(expected, actual, 0.1f);
  }
}