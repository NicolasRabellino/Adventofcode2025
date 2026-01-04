package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Elfos4 {
    public static void main(String[] args) throws Exception {

        char[][] grid = loadGrid(args[0]);
        int password = 0;
        int deletedInThisLoop = 0;
        boolean canDelete = true;
        while (canDelete) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {

                    if (grid[i][j] != '@') continue;

                    if ((i == 0 || i == grid.length - 1) && (j == 0 || j == grid[0].length - 1)) {
                        grid[i][j] = '.';
                        deletedInThisLoop++;
                        password++;
                        continue;
                    }

                    if (checkAround(grid, i, j) < 4) {
                        grid[i][j] = '.';
                        deletedInThisLoop++;
                        password++;
                    }
                }
            }

            if (deletedInThisLoop == 0) {
                canDelete = false;
            }

            deletedInThisLoop = 0;
        }


        System.out.println(password);

    }


    public static char[][] loadGrid(String inputString) throws IOException {
        List<String> input = Files.readAllLines(Path.of(inputString));
        char[][] grid = new char[input.size()][input.get(0).length()];

        for (int i = 0; i < input.size(); i++) {
            grid[i] = input.get(i).toCharArray();
        }

        return grid;
    }

    public static int checkAround(char[][] grid, int y, int x) {

        int totalAround = 0;
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {

                if (r == 0 && c == 0) continue;

                int rowToCheck = y + r;
                int colToCheck = x + c;
                if (rowToCheck >= 0 && rowToCheck < grid.length && colToCheck >= 0 && colToCheck < grid[0].length && grid[rowToCheck][colToCheck] == '@') {
                    totalAround++;
                }
                if(totalAround == 4) break;
            }
        }
        return totalAround;
    }

}
