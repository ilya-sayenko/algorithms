package bubble;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {100, 3, 2, 13, 34, 2, 6, 0};
        sort(array);
        Arrays.stream(array)
                .forEach(elem -> System.out.print(elem + " "));
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
