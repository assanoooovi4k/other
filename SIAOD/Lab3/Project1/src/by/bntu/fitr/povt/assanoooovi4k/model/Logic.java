package by.bntu.fitr.povt.assanoooovi4k.model;


public class Logic {
    public static int indexMinEl(DoubleLinkedList<Integer> doubleLinkedList) {
        int index = 0;
        Integer[] integers = doubleLinkedList.toArray(new Integer[doubleLinkedList.size()]);
        Integer integer = integers[0];

        for (int i = 0; i <integers.length ; i++) {
            if(integer<integers[i]) {
                integer = integers[i];
                index = i;
            }
        }

        return index;
    }
}
