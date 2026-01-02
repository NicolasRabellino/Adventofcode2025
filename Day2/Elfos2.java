import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Elfos2 {
    public static void main(String[] args) throws Exception {

        String input = Files.readString(Path.of(args[0])).trim();
        String[] ranges = input.split(",");
        System.out.println(checkRanges(ranges));
    }

    public static Boolean isInvalidNumber(long num) {

        String numString = Long.toString(num);
        int numStringLength = numString.length();

        for (int i = 1; i <= numStringLength / 2; i++) {

            if (numStringLength % i != 0) {
                continue;
            }

            String numPart = numString.substring(0, i);
            int lengthPart = numPart.length();
            int repetitions = numStringLength / lengthPart;

            String textToTest = "";
            for (int j = 0; j < repetitions; j++) {
                textToTest = textToTest + numPart;
            }
            if (textToTest.equals(numString)) {
                return true;
            }
        }
        return false;
    }


    public static long checkRanges(String[] ranges) {
        long totalNumber = 0;
        for (String range : ranges) {


            String[] nums = range.split("-");
            long begin = Long.parseLong(nums[0]);
            long end = Long.parseLong(nums[1]);

            for (long i = begin; i <= end; i++) {
                if (isInvalidNumber(i)) {
                    totalNumber += i;
                }
            }
        }
        return totalNumber;

    }

}

