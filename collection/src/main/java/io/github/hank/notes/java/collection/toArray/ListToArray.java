package io.github.hank.notes.java.collection.toArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListToArray {

    public static void test() {

        String[] array1 = {"1", "2", "3"};
        List<String> list1 = Arrays.asList(array1);

        int[] myArray = { 1, 2, 3 };
        List myList1 = Arrays.asList(myArray);
        System.out.println(myList1.size());//1
        System.out.println(myList1.get(0));//数组地址值
        System.out.println(myList1.get(1));//报错：ArrayIndexOutOfBoundsException
        int [] array=(int[]) myList1.get(0);
        System.out.println(array[0]);//1

        List myList2 = Arrays.asList(1, 2, 3);
        myList2.add(4);//运行时报错：UnsupportedOperationException
        myList2.remove(1);//运行时报错：UnsupportedOperationException
        myList2.clear();//运行时报错：UnsupportedOperationException

        List list = new ArrayList<>(Arrays.asList("a", "b", "c"));
    }

    static <T> List<T> arrayToList(final T[] array) {
        final List<T> l = new ArrayList<T>(array.length);

        for (final T s : array) {
            l.add(s);
        }
        return (l);
    }

    public void demo() {

        Integer [] myArray1 = { 1, 2, 3 };
        List myList1 = Arrays.stream(myArray1).collect(Collectors.toList());

        //基本类型也可以实现转换（依赖boxed的装箱操作）
        int [] myArray2 = { 1, 2, 3 };
        List myList2 = Arrays.stream(myArray2).boxed().collect(Collectors.toList());


        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);
        s=list.toArray(new String[0]);//没有指定类型的话会报错

    }

}
