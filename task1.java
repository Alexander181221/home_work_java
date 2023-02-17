package homeWork2;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class task1 {
    public static void main(String[] arg) throws ParseException {
        String sqlQuery = "SELECT * FROM students WHERE ";
        String strJson = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String result = getSqlQuery(sqlQuery, parseJsonStr(strJson));
        printToConsole(result);
    }

    // this method is used to print to the console
    public static void printToConsole(String strResult) {
        System.out.println("SQL query: ");
        System.out.println(strResult);
    }

    // this methos join strings
    public static String getSqlQuery(String sqlQuery, String parseJsonStr) {
        return sqlQuery + parseJsonStr;
    }

    // method parse JsonString
    public static String parseJsonStr(String jsonString) throws ParseException {
        StringBuilder sb = new StringBuilder();

        Object obj = new JSONParser().parse(jsonString);
        JSONObject jo = (JSONObject) obj;

        for (int i = 0; i < jo.keySet().toArray().length - 1; i++) {
            var item = jo.keySet().toArray()[i];
            String value = (String) jo.get(item);
            if (value.equals("null")) {
                continue;
            } else {
                sb.append(item).append('=').append('\'').append(value).append('\'');
            }
        }

        var lastItem = jo.keySet().toArray()[jo.keySet().toArray().length - 1];
        String lastValue = (String) jo.get(lastItem);

        if (!lastValue.equals("null")) {
            sb.append("AND").append(lastItem).append('=').append('\'').append(lastValue).append('\'');
        }
        sb.append(';');
        return sb.toString();

    }
}
