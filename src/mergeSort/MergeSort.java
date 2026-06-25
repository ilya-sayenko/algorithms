package mergeSort;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return; // Базовый случай: массив из 1 элемента уже отсортирован
        }

        // Находим середину, чтобы разделить массив пополам
        int mid = (right + left) / 2;

        // Рекурсивно сортируем левую и правую половины
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // Сливаем две отсортированные половины
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // Создаем временные массивы для левой и правой половин
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        // Копируем данные во временные массивы
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        // Индексы для прохода по временным массивам и основному массиву
        int i = 0; // Индекс для leftArr
        int j = 0; // Индекс для rightArr
        int k = left; // Индекс для arr

        // Сливаем элементы обратно в основной массив arr
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Добавляем оставшиеся элементы из leftArr, если они есть
        while (i < leftArr.length) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Добавляем оставшиеся элементы из rightArr, если они есть
        while (j < rightArr.length) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 5, 2, 3};

        System.out.println("Исходный массив: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }
}
