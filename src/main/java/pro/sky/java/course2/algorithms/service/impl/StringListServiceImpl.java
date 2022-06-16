package pro.sky.java.course2.algorithms.service.impl;

import pro.sky.java.course2.algorithms.service.StringListService;

import java.util.Arrays;

public class StringListServiceImpl implements StringListService {

    private String[] list;
    private int size;

    public StringListServiceImpl() {
        this.list = new String[5];
    }

    @Override
    public String[] getList() {
        return list;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String add(String item) {
        itemNotNull(item);
        if (size >= list.length) {
            list = Arrays.copyOf(list, (int) (list.length + (list.length * 0.5)));
        }
        list[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        incorrectIndex(index);
        System.arraycopy(list, index, list, index + 1, size - index);
        list[index] = item;
        size++;
        return item + " этот элемент добавлен, индекс = " + index;
    }

    @Override
    public String set(int index, String item) {
        itemNotNull(item);
        incorrectIndex(index);
        list[index] = item;
        return item + " этот элемент изменен, индекс = " + index;
    }

    @Override
    public String remove(String item) {
        itemNotNull(item);
        itemExist(item);
        int index = indexOf(item);
        if (index != list.length - 1) {
            System.arraycopy(list, index + 1, list, index, size - index);
            size--;
        }
        return item + " этот элемент удален по индексу = " + index;
    }

    @Override
    public String remove(int index) {
        incorrectIndex(index);
        String item = get(index);
        if (size - 1 - index >= 0) {
            System.arraycopy(list, index + 1, list, index, size - 1 - index);
            list[size - 1] = null;
            size--;
        }
        return item + " удален по индексу = " + index;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) >= 0;
    }

    @Override
    public int indexOf(String item) {
        itemNotNull(item);
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        itemNotNull(item);
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        incorrectIndex(index);
        return list[index];
    }

    @Override
    public boolean equals(StringListService otherList) {
        if (otherList == null) {
            return false;
        }
        if (size != otherList.getSize()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals((otherList.get(i)))) {
                return false;
            }
        }
        return true;
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
    public String[] toArray() {
        return Arrays.copyOf(list, size);
    }

    @Override
    public void printStringList() {
        for (int current = 0; current < size; current++) {
            if (lastIndexOf(list[current]) == size - 1) {
                System.out.println(list[current] + ".");
            } else {
                System.out.print(list[current] + ", ");
            }
        }
    }

    // ниже проверки
    private void incorrectIndex(int index) {
        if (index < 0 || index > getSize()) {
            throw new IndexOutOfBoundsException("Неправильный индекс");
        }
    }

    private void itemNotNull(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть нулевым");
        }
    }

    private void itemExist(String item) {
        if (indexOf(item) == -1) {
            throw new IllegalArgumentException("Объект не найден");
        }
    }
}