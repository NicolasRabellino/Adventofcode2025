package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Elfos3 {
    public static void main(String[] args) throws Exception {

        String[] input = Files.readAllLines(Path.of(args[0])).toArray(new String[0]);
        long joltageTotal = 0;
        for (String numEntero : input) {
            joltageTotal += findJoltage(numEntero);
        }

        System.out.println(joltageTotal);

    }

    public static long findJoltage(String numeroEntero) {

        long[] numeroEnteroInt = Arrays.stream(numeroEntero.split("")).mapToLong(Integer::parseInt).toArray();

        /*
   ------------------------------------------- 3.1 ----------------------------------------------------------------------

        int numA = 0, numB = 0, indexNumA = 0;
        for (int i = 0; i < numeroEnteroInt.length - 1; i++) {
            if (numeroEnteroInt[i] > numA) {
                numA = numeroEnteroInt[i];
                indexNumA = i;
            }
        }

        for (int i = indexNumA + 1; i < numeroEnteroInt.length; i++) {
            if (numeroEnteroInt[i] > numB) {
                numB = numeroEnteroInt[i];
            }
        }

    ------------------------------------------ 3.1 ----------------------------------------------------------------------
       */

// --------------------------------------------3.2------------------------------------------------------------------------------------------------
        long result = 0;
        int auxIndex = 0;

        for (int i = 0; i < 12; i++) {
            long max = 0;
            int indexMax = -1;

            for (int j = auxIndex; j <= numeroEnteroInt.length - (12 - i); j++) {
                if (numeroEnteroInt[j] > max) {
                    max = numeroEnteroInt[j];
                    indexMax = j;
                }
            }

            result = result * 10 + max;
            auxIndex = indexMax + 1;
        }

        return result;
// --------------------------------------------3.2------------------------------------------------------------------------------------------------

    }
}
