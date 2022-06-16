package pro.sky.java.course2.algorithms;

import pro.sky.java.course2.algorithms.service.StringListService;
import pro.sky.java.course2.algorithms.service.impl.StringListServiceImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringListService stringListService = new StringListServiceImpl();
        System.out.println(stringListService.add("Ivan"));
        System.out.println(stringListService.add("Victor"));
        System.out.println(stringListService.add("Petr"));
        System.out.println(stringListService.add("Fedor"));
        System.out.println(stringListService.add("Nikita"));
        System.out.println(stringListService.add("Mikhail"));
        System.out.println(stringListService.add(5, "Artem"));
        stringListService.printStringList();
        System.out.println(Arrays.toString(stringListService.getList()));
        System.out.println(stringListService.remove(0));
        System.out.println(Arrays.toString(stringListService.getList()));
        System.out.println(stringListService.remove(3));
        System.out.println(Arrays.toString(stringListService.getList()));
        System.out.println(stringListService.getSize());
        System.out.println(stringListService.remove("Victor"));
        System.out.println(Arrays.toString(stringListService.getList()));
    }
}
