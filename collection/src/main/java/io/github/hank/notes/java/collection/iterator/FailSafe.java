package io.github.hank.notes.java.collection.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafe {

    public static void main(String[] args) {

        arrayCopy();

        // 1. remove list item
        removeInList();

        // 2. remove in iterator
        //removeInIterator();

    }

    public static void arrayCopy() {
        Object[] a = {1, 2, 3};
        // 不是指针 是复制
        Object[] b = a;
        Object[] c = {1, 2};
        a = c;

        System.out.println("Array a:");
        printArray(a);
        System.out.println("Array b:");
        printArray(b);
        System.out.println("Array c:");
        printArray(c);
    }

    public static void removeInList() {
        List<Integer> integers = new CopyOnWriteArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        Iterator<Integer> itr = integers.iterator();
        while (itr.hasNext()) {
            Integer a = itr.next();
            integers.remove(a);
            System.out.println(a);
        }

        FailFast.printList(integers);
    }

    public static void removeInIterator() {
        List<Integer> integers = new CopyOnWriteArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        Iterator<Integer> itr = integers.iterator();
        while (itr.hasNext()) {
            Integer a = itr.next();
            if (Objects.equals(a, new Integer(1)))
                itr.remove();
        }

        FailFast.printList(integers);
    }

    public static void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " is: " + array[i]);
        }
    }

}
