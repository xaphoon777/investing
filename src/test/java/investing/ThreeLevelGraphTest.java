package investing;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeLevelGraphTest {

  @Test
  public void build() {
      float[] input = {100,105,107,104,102,108,106,104,109,104,100,103,102,99,105,97};
      float[] expected = {100,105,107,108,109,104,100,99,97};
      final float[] actual = ThreeLevelGraph.build(input);
      assertArrayEquals(expected, actual, 0.1f);
  }
}