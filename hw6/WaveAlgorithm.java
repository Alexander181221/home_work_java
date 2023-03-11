package newFolder.home_work_java.hw6;

import java.util.LinkedList;
import java.util.Queue;

public class WaveAlgorithm {
    public static void main(String[] args) {
    }

    public static void Wave_Algorithm(int[][] map, int[] startPos) {

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(startPos);
        map[startPos[0]][startPos[1]] = 1;

        while (queue.size() != 0) {
            int[] current_Position = queue.remove();
            int posX = current_Position[0];
            int posY = current_Position[1];

            if (map[posX - 1][posY] == 0) {
                int[] temp = new int[] { posX - 1, posY };
                queue.add(temp);
                map[posX - 1][posY] = map[posX][posY] + 1;
            }
            if (map[posX][posY - 1] == 0) {
                int[] temp = new int[] { posX, posY - 1 };
                queue.add(temp);
                map[posX][posY - 1] = map[posX][posY] + 1;
            }
            if (map[posX + 1][posY] == 0) {
                int[] temp = new int[] { posX + 1, posY };
                queue.add(temp);
                map[posX + 1][posY] = map[posX][posY] + 1;
            }
            if (map[posX][posY + 1] == 0) {
                int[] temp = new int[] { posX, posY + 1 };
                queue.add(temp);
                map[posX][posY + 1] = map[posX][posY] + 1;
            }
        }
    }
}
