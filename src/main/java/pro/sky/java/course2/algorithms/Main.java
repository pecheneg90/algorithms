package pro.sky.java.course2.algorithms;

import pro.sky.java.course2.algorithms.service.IntegerListService;
import pro.sky.java.course2.algorithms.service.StringListService;
import pro.sky.java.course2.algorithms.service.impl.IntegerListServiceImpl;
import pro.sky.java.course2.algorithms.service.impl.StringListServiceImpl;

import java.util.Arrays;

public class Main {
    static void strings() {
        StringListService stringListService = new StringListServiceImpl();
        System.out.println(stringListService.add("Ivan"));
        System.out.println(stringListService.add("Victor"));
        System.out.println(stringListService.add("Petr"));
        System.out.println(stringListService.add("Fedor"));
        System.out.println(stringListService.add("Nikita"));
        System.out.println(stringListService.add("Vladimir"));
        System.out.println(stringListService.add("Ivan"));
        System.out.println(stringListService.add("Victor"));
        System.out.println(stringListService.add("Petr"));
        System.out.println(stringListService.add("Fedor"));
        System.out.println(stringListService.add("Mikhail"));
        System.out.println(stringListService.add("Ivan"));
        System.out.println(stringListService.add("Victor"));
        System.out.println(stringListService.add("Petr"));
        System.out.println(stringListService.add("Fedor"));
        System.out.println(stringListService.getSize());
        System.out.println(Arrays.toString(stringListService.getList()));
        System.out.println(stringListService.add(0, "Evgeny"));
        System.out.println(stringListService.add(1, "Viktor"));
        System.out.println(stringListService.remove(0));
        System.out.println(stringListService.set(5, "Ignat"));
        stringListService.remove(10);
        System.out.println(stringListService.contains("Fedor"));
        System.out.println(Arrays.toString(stringListService.getList()));
        System.out.println(stringListService.add(0, "Maria"));
        System.out.println(stringListService.add(1, "Eugenia"));
        System.out.println(stringListService.add(0, "Janna"));
        System.out.println(stringListService.add(1, "Polina"));
        System.out.println(stringListService.add(0, "Maria"));
        System.out.println(stringListService.add(1, "Eugenia"));
        System.out.println(stringListService.add(0, "Janna"));
        System.out.println(stringListService.add(1, "Polina"));
        System.out.println(Arrays.toString(stringListService.getList()));
    }

    static void integers() {
        IntegerListService integerListService = new IntegerListServiceImpl();
        System.out.println(integerListService.add(2) + " - добавлен по значению");
        System.out.println(integerListService.add(53) + " - добавлен по значению");
        System.out.println(integerListService.add(234) + " - добавлен по значению");
        System.out.println(integerListService.add(2443) + " - добавлен по значению");
        System.out.println(integerListService.add(231) + " - добавлен по значению");
        System.out.println(integerListService.add(12) + " - добавлен по значению");
        System.out.println(integerListService.add(42) + " - добавлен по значению");
        System.out.println(integerListService.add(1234) + " - добавлен по значению");
        System.out.println(integerListService.add(234) + " - добавлен по значению");
        System.out.println(integerListService.add(23) + " - добавлен по значению");
        System.out.println(integerListService.add(90) + " - добавлен по значению");
        System.out.println(integerListService.add(234) + " - добавлен по значению");
        System.out.println(integerListService.add(23) + " - добавлен по значению");
        System.out.println(integerListService.add(8848) + " - добавлен по значению");
        System.out.println(integerListService.add(123) + " - добавлен по значению");
        System.out.println(integerListService.getSize() + " - получен размер массива");
        System.out.println(Arrays.toString(integerListService.getList()) + " - получен весь массив");
        System.out.println("добавлен по индексу и по значению - " + integerListService.add(0, 9999));
        System.out.println("добавлен по индексу и по значению - " + integerListService.add(1, 8888));
        System.out.println("удален по индексу - " + integerListService.remove(0));
        System.out.println("изменен по индексу и по значению - " + integerListService.set(5, 1111));
        System.out.println(integerListService.contains(8888));
        System.out.println(Arrays.toString(integerListService.getList()) + " - получен весь массив");
        System.out.println(integerListService.add(0, 4444) + " - добаввлен по индексу и по значению");
        System.out.println(integerListService.add(1, 5555) + " - добаввлен по индексу и по значению");
        System.out.println(integerListService.add(0, 3333) + " - добаввлен по индексу и по значению");
        System.out.println(integerListService.add(1, 2222) + " - добаввлен по индексу и по значению");
        System.out.println(integerListService.add(0, 8888) + " - добаввлен по индексу и по значению");
        System.out.println(integerListService.add(1, 3333) + " - добаввлен по индексу и по значению");
        System.out.println(integerListService.add(0, 7777) + " - добаввлен по индексу и по значению");
        System.out.println(integerListService.add(1, 9999) + " - добаввлен по индексу и по значению");
        System.out.println(Arrays.toString(integerListService.getList()) + " - получен весь массив");
        IntegerListServiceImpl.quickSort(integerListService.getList(), 0, integerListService.getSize() - 1);
        System.out.println(Arrays.toString(integerListService.getList())
                + "получен весь массив после быстрой (рекурсивной) сортировки)");
    }

    public static Integer[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        Integer[] arr = new Integer[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 1;
        }
        return arr;
    }

    public static void arraysIntegers() {

        IntegerListServiceImpl integerListService = new IntegerListServiceImpl();
        Integer[] arr1 = generateRandomArray();
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);


        long start1 = System.currentTimeMillis();
        IntegerListServiceImpl.sortBubble(arr1);
        System.out.println(System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();
        IntegerListServiceImpl.sortSelection(arr2); // быстрая
        System.out.println(System.currentTimeMillis() - start2);

        long start3 = System.currentTimeMillis();
        IntegerListServiceImpl.sortInsertion(arr3);
        System.out.println(System.currentTimeMillis() - start3);

        System.out.println(Arrays.toString(integerListService.getListRandom(arr1)));
    }

    public static void main(String[] args) {
//        strings();
        integers();
//        arraysIntegers();
    }
}