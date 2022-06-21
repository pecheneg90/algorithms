package pro.sky.java.course2.algorithms.service.impl;

import pro.sky.java.course2.algorithms.service.StringListService;

import java.util.Arrays;

public class StringListServiceImpl implements StringListService {

    private String[] list;
    private int size;

    public StringListServiceImpl() {
        list = new String[10];
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
        isArrayNotFull();
        list[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        itemNotNull(item);
        incorrectIndex(index);
        isArrayNotFull();
        if (index != size) {
            System.arraycopy(list, index, list, index + 1, size - index);
            list[index] = item;
            size++;
        }
        return item + " этот элемент добавлен, индекс = " + index;
    }

    @Override
    public String remove(String item) {
        itemNotNull(item);
        itemExist(item);
        int index = indexOf(item);
        return remove(index) + " этот элемент удален по индексу = " + index;
    }

    @Override
    public String remove(int index) {
        incorrectIndex(index);
        String item = get(index);
        if (index != size) {
            System.arraycopy(list, index + 1, list, index, size - index);
        }
        size--;
        return item + " удален по индексу = " + index;
    }

    @Override
    public String get(int index) {
        incorrectIndex(index);
        return list[index];
    }

    @Override
    public String set(int index, String item) {
        itemNotNull(item);
        incorrectIndex(index);
        list[index] = item;
        return item + " этот элемент изменен, индекс = " + index;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) >= 0;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean equals(StringListService otherList) {
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
    public String[] toArray() {
        return Arrays.copyOf(list, size);
    }

    // ниже проверки, вспомогательные методы
    private void incorrectIndex(int index) {
        if (index < 0 || index > getSize()) {
            throw new IndexOutOfBoundsException("Неправильный индекс");
        }
    }

    private void itemExist(String item) {
        if (indexOf(item) == -1) {
            throw new IllegalArgumentException("Объект не найден");
        }
    }

    private void itemNotNull(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть нулевым");
        }
    }

    private void isArrayNotFull() {
        if (size == list.length) {
            list = extend();
        }
    }

    private String[] extend() {
        return Arrays.copyOf(list, size + 5);
    }
}