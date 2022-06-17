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
        System.out.println(stringListService.add(0,"Evgeny"));
        System.out.println(stringListService.add(1,"Viktor"));
        System.out.println(stringListService.remove(0));
        System.out.println(stringListService.set(5, "Ignat"));
        stringListService.remove(10);
        System.out.println(stringListService.contains("Fedor"));
        System.out.println(Arrays.toString(stringListService.getList()));
        System.out.println(stringListService.add(0,"Maria"));
        System.out.println(stringListService.add(1,"Eugenia"));
        System.out.println(stringListService.add(0,"Janna"));
        System.out.println(stringListService.add(1,"Polina"));
        System.out.println(stringListService.add(0,"Maria"));
        System.out.println(stringListService.add(1,"Eugenia"));
        System.out.println(stringListService.add(0,"Janna"));
        System.out.println(stringListService.add(1,"Polina"));
        System.out.println(Arrays.toString(stringListService.getList()));
    }
}