package investing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ThreeLevelGraphTest {

    @Test
    public void build() {
        List<Float> input = List.of(100f, 105f, 107f, 104f, 102f, 108f, 106f, 104f, 109f, 104f, 100f, 103f, 102f, 99f, 105f, 97f);
        List<Float> expected = List.of(100f, 105f, 107f, 108f, 109f, 104f, 100f, 99f, 97f);
        List<Float> actual = ThreeLevelGraph.build(input);
        assertEquals(expected, actual);
    }
}