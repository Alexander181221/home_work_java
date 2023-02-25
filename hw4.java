package javahw4;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class hw4 {
    public void sort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        for (int i = n - 1; i > 0; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;

            heapify(array, i, 0);
        }
    }

    void heapify(int[] array, int m, int k) {
        int largest = k; 
        int l = 2 * k + 1; 
        int r = 2 * k + 2; 

        if (l < m && array[l] > array[largest])
            largest = l;

        if (r < m && array[r] > array[largest])
            largest = r;

        if (largest != k) {
            int swap = array[k];
            array[k] = array[largest];
            array[largest] = swap;

            heapify(array, m, largest);
        }
    }

    static void printArray(int[] array) {
        MyLogger.writeLog(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] a1 = new int[] { 1, 27, 29, 1, 90, 500, 23, 9000, 1000, 232, 226, 3, 0, 85, 85 };

        hw4 ob = new hw4();
        ob.sort(a1);

        printArray(a1);
    }
}

class MyLogger {
    private MyLogger() {
        throw new IllegalStateException("Utility class");
    }

    private static final Logger log = Logger.getLogger("MyLogger");

    static {
        FileHandler fh;

        try {
            fh = new FileHandler("log.log", false);
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }

    public static void writeLog(String message) {
        log.log(Level.INFO, message);
    }

    public static void writeLog(String message, Exception e) {
        log.log(Level.WARNING, message, e);
    }
}