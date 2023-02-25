package javaHw3;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class hw3 {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 27, 29, 1, 90, 500, 23, 9000, 1000, 232, 226, 3, 0, 85, 85 };
        mergeSort(array, array.length);
        MyLogger.writeLog(Arrays.toString(array));
    }

    public static void mergeSort(int[] sourceArr, int n) {
        if (n < 2)
            return;
        int mid = n / 2;
        int[] arr1 = new int[mid];
        int[] arr2 = new int[n - mid];

        System.arraycopy(sourceArr, 0, arr1, 0, mid);
        if (n - mid >= 0)
            System.arraycopy(sourceArr, mid, arr2, 0, n - mid);
        mergeSort(arr1, mid);
        mergeSort(arr2, n - mid);

        merge(sourceArr, arr1, arr2, mid, n - mid);
    }

    public static void merge(int[] arr1, int[] arr2, int[] r, int left, int right) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left && j < right) {

            if (arr2[i] <= r[j])
                arr1[k++] = arr2[i++];
            else
                arr1[k++] = r[j++];

        }

        while (i < left)
            arr1[k++] = arr2[i++];

        while (j < right)
            arr1[k++] = r[j++];
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
