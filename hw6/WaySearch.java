package newFolder.home_work_java.hw6;

public class WaySearch {
    public static void main(String[] args) {
    }

    public static int[][] SearchWays(int[][] arr) {
        int x = 0;
        int y = 0;
        int max = 0;
        int[][] Array = new int[arr.length][arr[0].length];
        Array = arr;
        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array[0].length; j++) {
                if (Array[i][j] == -2) {
                    x = i;
                    y = j;
                }

                if (Array[i][j] > max) {
                    max = Array[i][j];
                }

            }
        }
        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array[0].length; j++) {
                while (max > 0) {
                    if (x > 0 && y > 0) {
                        if (Array[x + 1][y] == max) {
                            x = x + 1;
                            if (Array[x][y] != 1) {
                                Array[x][y] = -3;
                            }
                        }
                    }
                    if (x > 0 && y > 0) {
                        if (Array[x - 1][y] == max) {
                            x = x - 1;
                            if (Array[x][y] != 1) {
                                Array[x][y] = -3;
                            }
                        }
                    }
                    if (x > 0 && y > 0) {
                        if (Array[x][y + 1] == max) {
                            y = y + 1;
                            if (Array[x][y] != 1) {
                                Array[x][y] = -3;
                            }
                        }
                    }
                    if (x > 0 && y > 0) {
                        if (Array[x][y - 1] == max) {
                            y = y - 1;
                            if (Array[x][y] != 1) {
                                Array[x][y] = -3;
                            }
                        }
                    }
                    max--;
                }

            }

        }
        return Array;
    }
}
