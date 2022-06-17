package pro.sky.java.course2.algorithms.service;

public interface StringListService {

    String add(String item);

    String add(int index, String item);

    String set(int index, String item);

    String remove(String item);

    String remove(int index);

    boolean contains(String item);

    int indexOf(String item);

    int lastIndexOf(String item);

    String get(int index);

    boolean equals(StringListService otherList);

    boolean isEmpty();

    void clear();

    String[] toArray();

    String[] getList();

    int getSize();

}