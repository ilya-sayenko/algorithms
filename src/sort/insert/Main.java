package sort.insert;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[] {100, 3, 2, 13, 34, 2, 6, 0};
        sort(array);
        Arrays.stream(array)
                .forEach(elem -> System.out.print(elem + " "));
    }

    public static void sort(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            int j = i - 1;
            while (j >= 0 && array[j + 1] < array[j]) {
                int element = array[j + 1];
                array[j + 1] = array[j];
                array[j] = element;
                j -= 1;
            }
        }
    }
}
