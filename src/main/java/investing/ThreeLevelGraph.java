package investing;

import java.util.ArrayList;
import java.util.List;


public class ThreeLevelGraph {


    private static float max = 0;
    private static float min = 0;

    public static List<Float> build(List<Float> input) {
        List<Float> output = new ArrayList<>();
        int days = 0;

        for (float current : input) {
            if (days > 3) {
                if (current < min) {
                    min = current;
                    output.add(current);
                    updateExtemums(output.subList(output.size() - days, output.size()));


                } else {
                    if (current > max) {
                        max = current;
                        output.add(current);
                        updateExtemums(output.subList(output.size() - days, output.size()));


                    }

                }


            } else {
                //less than 4 numbers(3 bands)


                if (output.size() == 0) {
                    output.add(current);
                    days += 1;
                    min = current;
                    max = current;

                } else {
                    if (current < min) {
                        min = current;
                        days += 1;
                        output.add(current);

                    } else {
                        if (current > max) {
                            max = current;
                            days += 1;
                            output.add(current);

                        }

                    }

                }
            } //end of "else" less 4 numbers(3 bands)

        }
        return output;
    }

    private static void updateExtemums(List<Float> tail) {
        max = tail.get(0);
        min = tail.get(0);
        for (Float aFloat : tail) {
            if (aFloat <= min) {
                min = aFloat;
            }
            if (aFloat >= max) {
                max = aFloat;
            }
        }
    }
}
