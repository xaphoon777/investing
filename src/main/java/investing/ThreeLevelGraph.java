package investing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ThreeLevelGraph {


    private static float max = 0;
    private static float min = 0;

    public static List<Float> build(List<Float> input) {
        List<Float> output = new ArrayList<>();
        int days = 0;

        for (float current : input) {

            if ((output.size() == 0) && (days < 3)) {
                output.add(current);
                days += 1;
                min = current;
                max = current;

            } else {
                if (current < min) {
                    min = current;
                    days += 1;
                    updateExtemums(output.subList(output.size() - (days - 1), output.size() - 1));
                    output.add(current);

                } else {
                    if (current > max) {
                        max = current;
                        days += 1;
                        updateExtemums(output.subList(output.size() - (days - 1), output.size() - 1));
                        output.add(current);

                    }

                }

            }

        }
        return output;
    }

    private static void updateExtemums(List<Float> tail) {
        for (Float aFloat : tail) {
            if (aFloat < min) {
                min = aFloat;
            }
            if (aFloat > max) {
                max = aFloat;
            }
        }
//        max = tail.stream().max(Float::compareTo).get();
//        min = tail.stream().min(Float::compareTo).get();
    }
}
