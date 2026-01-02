package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Elfos3 {
    public static void main(String[] args) throws Exception {

        String[] input = Files.readAllLines(Path.of(args[0])).toArray(new String[0]);
        int joltageTotal = 0;
        for (String numEntero : input) {
            joltageTotal += findJoltage(numEntero);
        }

        System.out.println(joltageTotal);

    }

    public static int findJoltage(String numeroEntero) {

        int[] numeroEnteroInt = Arrays.stream(numeroEntero.split("")).mapToInt(Integer::parseInt).toArray();

        int numA = 0, numB = 0, indexNumA = 0;
        for(int i = 0; i < numeroEnteroInt.length-1; i++) {
            if(numeroEnteroInt[i] > numA){
                numA = numeroEnteroInt[i];
                indexNumA = i;
            }
        }

        for(int i = indexNumA + 1; i < numeroEnteroInt.length; i++) {
            if(numeroEnteroInt[i] > numB){
                numB = numeroEnteroInt[i];
            }
        }

        return numA * 10 + numB;
    }
}
