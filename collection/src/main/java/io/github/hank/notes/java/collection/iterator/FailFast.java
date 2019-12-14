package io.github.hank.notes.java.collection.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class FailFast {

    public static void main(String[] args) {

        // 1. Iterator fail-fast
        //iteratorFail();

        // 2. foreach fail-fast
        //foreachFail();

        // 3.right way to remove item in the loop
        rightWay();

    }

    public static void iteratorFail() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        /** fail-fast in Iterator
         * Throw ConcurrentModificationException
         */
        Iterator<Integer> it = integers.iterator();
        while(it.hasNext()) {
            Integer integer = it.next();
            integers.remove(integer);
        }

        printList(integers);
    }

    public static void foreachFail() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        /**
         * fail-fast in foreach
         */
        for (Integer i : integers) {
            integers.remove(i);
        }

        printList(integers);

    }

    public static void rightWay() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        Iterator<Integer> it = integers.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (Objects.equals(i, new Integer(1)))
                it.remove();
        }

        printList(integers);
    }

    public static void printList(List list) {
        System.out.println("Print the list:");
        list.forEach(item -> System.out.println(item));
    }

}
