package pro.sky.java.course2.algorithms.service.impl;

import pro.sky.java.course2.algorithms.service.IntegerListService;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListServiceImpl implements IntegerListService {

    private Integer[] list;
    private int size;

    public IntegerListServiceImpl() {
        list = new Integer[10];
    }

    @Override
    public Integer[] getList() {
        return list;
    }

    public Integer[] getListRandom(Integer[] arr) {
        return arr;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Integer add(Integer item) {
        itemNotNull(item);
        isArrayNotFull();
        list[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        itemNotNull(item);
        incorrectIndex(index);
        isArrayNotFull();
        if (index != size) {
            System.arraycopy(list, index, list, index + 1, size - index);
            list[index] = item;
            size++;
        }
        return item + index;
    }

    @Override
    public Integer remove(Integer item) {
        itemNotNull(item);
        itemExist(item);
        int index = indexOf(item);
        return remove(index) + index;
    }

    @Override
    public Integer remove(int index) {
        incorrectIndex(index);
        Integer item = get(index);
        if (index != size) {
            System.arraycopy(list, index + 1, list, index, size - index);
        }
        size--;
        return item + index;
    }

    @Override
    public Integer get(int index) {
        incorrectIndex(index);
        return list[index];
    }

    @Override
    public Integer set(int index, Integer item) {
        itemNotNull(item);
        incorrectIndex(index);
        list[index] = item;
        return item + index;
    }

    @Override
    public boolean contains(Integer item) {
        sortSelection();
        return binarySearch(item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean equals(IntegerListService otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(list, size);
    }

    private void sortSelection() {
        for (int i = 0; i < size - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (list[j] < list[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            int tmp = list[i];
            list[i] = list[minElementIndex];
            list[minElementIndex] = tmp;
        }
    }

    private boolean binarySearch(Integer item) {
        int min = 0;
        int max = size - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (Objects.equals(item, list[mid])) {
                return true;
            }
            if (item < list[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    // ниже проверки, вспомогательные методы
    private void incorrectIndex(int index) {
        if (index < 0 || index > getSize()) {
            throw new IndexOutOfBoundsException("Неправильный индекс");
        }
    }

    private void itemExist(Integer item) {
        if (indexOf(item) == -1) {
            throw new IllegalArgumentException("Объект не найден");
        }
    }

    private void itemNotNull(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть нулевым");
        }
    }

    private void isArrayNotFull() {
        if (size == list.length) {
            list = grow();
        }
    }

    private Integer[] grow() {
        return Arrays.copyOf(list, (int) (size * 1.5));
    }

    //сортировки

    public static void swapElements(Integer[] data, int indexA, int indexB) {
        int tmp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = tmp;
    }


    public static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void quickSort(Integer[] list, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(list, begin, end);

            quickSort(list, begin, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] list, int begin, int end) {
        int pivot = list[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (list[j] <= pivot) {
                i++;

                swapElements(list, i, j);
            }
        }

        swapElements(list, i + 1, end);
        return i + 1;
    }
}