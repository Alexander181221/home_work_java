package homeWork2;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task2 {
    public static void main(String[] args) {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(1, 100);
        }
        BubbleSort bubblesort = new BubbleSort(array);
        bubblesort.bubbleSort();
    }
}

class MyLogger {
    private static final Logger log = Logger.getLogger("MyLogger");

    static {
        FileHandler fh;

        try {
            fh = new FileHandler("file.txt", false);
            log.addHandler(fh);
            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);
        } catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }

    public static void writeLog(String msg) {
        log.log(Level.INFO, msg);
    }

    public static void writeLog(String msg, Exception e) {
        log.log(Level.WARNING, msg, e);
    }
}

class BubbleSort {
    private int[] array;

    public BubbleSort(int[] arr) {
        this.array = arr;
    }

    public void bubbleSort() {
        int countStar = 0;
        int countEnd = 0;
        int countIter = 0;
        int temp = 0;
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < array.length - 1; i++) {
                MyLogger.writeLog(Arrays.toString(array));
                if (array[i] > array[i + 1]) {
                    temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    countEnd++;
                }
            }
            printArray();
            ++countIter;
            if (countStar == countEnd) {
                flag = false;
            } else {
                countEnd = 0;
            }
        }
        System.out.printf("Отсоратированно за %d проходов \n", countIter);
    }

    public void printArray() {
        System.out.println(Arrays.toString(array));
    }

    public int[] getArray() {
        return array;
    }
}