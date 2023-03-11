package newFolder.home_work_java.hw6;

public class App {
    public static void main(String[] args) {

        var map = GetMap.getMap();
        // System.out.println(rawData(map));
        System.out.println(PrintMap.Print_Map(map));
        MyLogger.writeLog("Map created");

        int[] startPos = getPoint2D(1, 1);
        WaveAlgorithm.Wave_Algorithm(map, startPos);
        // System.out.println(rawData(map));
        int[][] map1 = WaySearch.SearchWays(map);
        // System.out.println(rawData(map1));
        System.out.println(PrintMap.Print_Map(map1));
        MyLogger.writeLog("Path created");
    }

    private static int[] getPoint2D(int x, int y) {
        return new int[] { x, y };

    }
    // Вспомогатальный метод для отладки - контроль содержимого массива:
    // static String rawData(int[][] map) {
    // StringBuilder sb = new StringBuilder();
    // for (int row = 0; row < map.length; row++) {
    // for (int col = 0; col < map[row].length; col++) {
    // sb.append(String.format("%2d", map[row][col]));
    // }
    // sb.append("\n");
    // }
    // return sb.toString();
    // }
}