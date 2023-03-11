package newFolder.home_work_java.hw5;

public class PrintMap {
    public static void main(String[] args) {

        // var map = GetMap.getMap();
        // System.out.println(rawData(getMap()));
        // System.out.println(PrintMap(GetMap.getMap()));
    }

    static String Print_Map(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                switch (map[row][col]) {
                    case 0:
                        sb.append("  ");
                        break;
                    case -1:
                        sb.append("||");
                        break;
                    case -2:
                        sb.append("Ex");
                        break;
                    case -3:
                        sb.append(" *");
                        break;
                    case 1:
                        sb.append("En");
                        break;
                    default:
                        sb.append("  ");
                        break;
                }
            }
            sb.append("\n");
        }
        for (int i = 0; i < 3; i++) {
            sb.append("\n");
        }
        return sb.toString();
    }
}
