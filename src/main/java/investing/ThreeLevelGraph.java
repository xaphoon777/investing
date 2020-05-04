package investing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ThreeLevelGraph {


    private static float max = 0;
    private static float min = 0;

    public static List<Float> build(List<Float> input) {
        List<Float> output = new ArrayList<>();
        int days = 3;

        for (float current : input) {
            if (output.size() == 0) {
                output.add(current);
                min = current;
                max = current;
            } else {
                if (current < min) {
                    min = current;
                    updateExtemums(output.subList(output.size()-days-1,output.size()-1));
                    output.add(current);
                } else {
                    if (current > max) {
                        max = current;
                        updateExtemums(output.subList(output.size()-days-1,output.size()-1));
                        output.add(current);
                    }

                }

            }

        }
        return output;
    }

    private static void updateExtemums ( List <Float> tail) {
        max = tail.stream().max(Float::compareTo).get();
        min = tail.stream().min(Float::compareTo).get();
    }
}
